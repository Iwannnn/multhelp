// pages/message/message.js
const app=getApp()

Page({
  /**
   * 页面的初始数据
   */
  data: {
    messageSocket:"",
    messages:[],
  },
  onLoad: function(){
    this.createWebSocket()
  },
  onShow: function(){
    app.checkSession_3rd();
  },
  createWebSocket: function(){
    var that=this
    this.data.messageSocket=wx.connectSocket({
      url: app.globalData.socket+'/wx/message/'+app.globalData.session_3rd,
    })

    this.data.messageSocket.onMessage((res)=>{
      var messages=JSON.parse(res.data);
      console.log(res.data)
      that.setData({
        messages:messages
      })
    })
  },

})