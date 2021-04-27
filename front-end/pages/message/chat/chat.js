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
    myProfile:{},
    otherProfile:{},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var postid=options.postid
    var chatid=options.chatid
    this.setData({
      nbTitle: '求助详情',
      nbLoading: false,
      postid:postid
    })
    app.checkSession_3rd()
    if(postid){
      this.createChat()
      this.getOtherProfileByPostID()
    }
    if(chatid){
      this.getOtherProfileByChatID()
    }
  },
  getOtherProfileByPostID:function(){
    var that=this;
    var postid=this.data.postid
    console.log(postid)
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
        console.log("mydata")
        console.log(that.data.myProfile)
        console.log("otherdata")
        console.log(that.data.otherProfile)
      }
    })
  },
  getOtherProfileByChatID:function(){
    var that=this;
    var chatid=this.data.chatid
    console.log(chatid)
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
        console.log("mydata")
        console.log(that.data.myProfile)
        console.log("otherdata")
        console.log(that.data.otherProfile)
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
        console.log("create successfully")
      }
    })
  }
})