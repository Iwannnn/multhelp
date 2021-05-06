// pages/message/chat/chat.js
const app=getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    nbFrontColor: '#000000',
    nbBackgroundColor: '#fae4fa',
    postid:'',
    chatid:'',
    identity:'initiator',
    content:'',
    contents:[],
    myProfile:{},
    otherProfile:{},
    test:[],
    chatSocket:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var postid=options.postid
    var chatid=options.chatid
    this.setData({
      nbTitle: '聊天',
      nbLoading: false,
      postid:options.postid,
      chatid:options.chatid
    })    
  },
  onShow: function(){
    app.checkSession_3rd()
    this.getAccount()
  },
  onUnload: function(){
    wx.closeSocket()
  },
  createWebSocket: function(){
    var that=this;
    
    this.data.chatSocket=wx.connectSocket({
      url: app.globalData.socket +'/wx/chat/'+ this.data.chatid,
    })
    this.data.chatSocket.onMessage((res) => {
      console.log(res.data)
      var content = JSON.parse(res.data);
      if(content.sender!=this.data.identity){
        content.isRead=true
        this.isRead(content.contentid)
      }
      that.data.contents=that.data.contents.concat(content)
      that.setData({
        contents: that.data.contents,
      })
      that.srcollTo()
    })
  },
  getAccount: function(){
    var chatid=this.data.chatid
    var postid=this.data.postid
    if(chatid){
      this.checkIdentity()
      this.createWebSocket()
      this.getOtherProfileByChatID()
      this.getPrevContents()
    }
    if(postid){
      this.createChat()
      this.getOtherProfileByPostID()
    }
  },
  checkIdentity: function(){
    var that=this
    wx.request({
      url: app.globalData.domain +'/wx/chat/checkIdentity',
      data:{
        chatid:that.data.chatid,
        session_3rd:app.globalData.session_3rd
      },
      success:request_res=>{
        that.setData({
          identity:request_res.data
        })
      }
    })
  },
  getOtherProfileByPostID:function(){
    var that=this;
    var postid=this.data.postid
    wx.request({
      url: app.globalData.domain+'/wx/account/getOtherProfileByPostID',
      data:{
        session_3rd:app.globalData.session_3rd,
        postid:postid
      },
      success:request_res=>{
        that.setData({
          myProfile:request_res.data[0],
          otherProfile:request_res.data[1]
        })
      }
    })
  },
  getOtherProfileByChatID:function(){
    var that=this;
    var chatid=this.data.chatid
    wx.request({
      url: app.globalData.domain+'/wx/account/getOtherProfileByChatID',
      data:{
        session_3rd:app.globalData.session_3rd,
        chatid:chatid
      },
      success:request_res=>{
        that.setData({
          myProfile:request_res.data[0],
          otherProfile:request_res.data[1]
        })
      }
    })
  },
  createChat:function(){
    var that=this;
    var postid =this.data.postid
    wx.request({
      url: app.globalData.domain + '/wx/chat/createChat',
      data:{
        session_3rd:app.globalData.session_3rd,
        postid:postid
      },
      success:request_res=>{
        that.setData({
          chatid:request_res.data
        })
        that.checkIdentity()
        that.createWebSocket()
        that.getPrevContents()
      }
    })
  },
  getMessage: function(e){
    this.setData({
      content:e.detail.value
    })
  },
  sendMessage: function(){
    var that=this
    that.data.chatSocket.send({
      data:app.globalData.session_3rd+" "+that.data.content
    })
    // wx.sendSocketMessage({
    //   data:app.globalData.session_3rd+" "+that.data.content
    // })
    this.setData({
    	content: ''
    })
  },
  getPrevContents: function(){
    var that=this
    wx.request({
      url:app.globalData.domain + '/wx/chat/getPrevContents',
      data:{
        chatid:that.data.chatid
      },
      success:request_res=>{
        console.log(request_res.data)
        var contents=request_res.data
        for(var i=0;i<contents.length;i++){
          if(contents[i].sender!=that.data.identity){
            contents[i].isRead=true
            this.isRead(contents[i].contentid)
            console.log("read")
          }
        }
        that.setData({
          contents:contents,
        })
        that.srcollToStart()
      }
    })
  },
  srcollToStart:function (){
    wx.pageScrollTo({
      scrollTop: this.data.contents.length*1000,
      duration: 0
    })
  },
  srcollTo:function (){
    wx.pageScrollTo({
      scrollTop: this.data.contents.length*1000,
      duration: 300
    })
  },
  isRead: function(contentid){
    wx.request({
      url: app.globalData.domain + '/wx/chat/isRead',
      data:{
        contentid:contentid
      }
    })
  }
})