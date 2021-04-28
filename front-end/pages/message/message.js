// pages/message/message.js
const app=getApp()

Page({
  /**
   * 页面的初始数据
   */
  data: {
    response:""
  },
  /**
   * 生命周期函数--监听页面显示
   */

  onLoad: function () {
    var that = this
    // 创建一个 WebSocket 连接
    wx.connectSocket({
      url: app.globalData.socket +'/wx/message',
    })
    // 监听 WebSocket 连接打开事件
    wx.onSocketMessage((res) => {
      console.log(res.data)
    })
  },
  send:function(){
    console.log("123")
    wx.sendSocketMessage({
      data: "123",
    })
  }
})