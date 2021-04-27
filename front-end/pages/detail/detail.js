// pages/detail/detail.js
const app=getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    nbFrontColor: '#000000',
    nbBackgroundColor: '#fae4fa',
    postid:"",
    postDetail:"",
  },
  onLoad: function (options) {
    var postid=options.postid
    this.setData({
      nbTitle: '求助详情',
      nbLoading: false,
      postid:postid
    })
    app.checkSession_3rd()
    this.getPostDetail()
  },
  getPostDetail:function(){
    var that=this;
    wx.request({
      url: app.globalData.domain + '/wx/post/getPostDetail',
      data:{
        postid:that.data.postid
      },
      success:request_res=>{
        console.log(request_res.data)
        that.setData({
          postDetail:request_res.data
        })
      }
    })
  },
  helpPost:function(){
    var that=this;
    app.checkSession_3rd();
    console.log(app.globalData.session_3rd)
    console.log(that.data.postid)
    wx.request({
      url: app.globalData.domain + '/wx/post/helpPost',
      data:{
        session_3rd:app.globalData.session_3rd,
        postid:that.data.postid
      },
      success:request_res=>{
        console.log(request_res.data)
      }
    })
  },
  contact:function(){
    wx.navigateTo({
      url: '/pages/message/chat/chat?postid='+this.data.postid,
    })
  }
})