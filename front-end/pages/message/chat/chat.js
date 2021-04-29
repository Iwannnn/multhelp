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
    srcollTop:0,
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
    app.checkSession_3rd()
    this.getAccount()
  },
  createWebSocket: function(){
    var that=this;
    wx.connectSocket({
      url: app.globalData.socket +'/wx/chat/'+ this.data.chatid,
    })
    wx.onSocketMessage((res) => {
      var content = JSON.parse(res.data);
      that.data.contents=that.data.contents.concat(content)
      that.setData({
        contents: that.data.contents,
        scrollTop:that.data.contents.length*1000
      })
    })
  },
  getAccount: function(callback){
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
        console.log(this.data.myProfile)
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
    wx.sendSocketMessage({
      data:app.globalData.session_3rd+" "+that.data.content
    }),
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
        that.setData({
          contents:request_res.data,
          scrollTop:request_res.data.length*1000
        })
      }
    })
  },
})