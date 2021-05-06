// pages/message/message.js
const app=getApp()

Page({
  /**
   * 页面的初始数据
   */
  data: {
    response:"",
    messageSocket:""
  },
  onLoad: function(){
    this.createWebSocket()
  },
  createWebSocket: function(){
    var that=this
    this.data.messageSocket=wx.connectSocket({
      url: app.globalData.socket+'/wx/message/'+app.globalData.session_3rd,
    })

    this.data.messageSocket.onMessage((res)=>{
      console.log(res.data)
    })
  },

})