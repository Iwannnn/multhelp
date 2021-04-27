// pages/message/message.js

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
  onShow: function () {
    var that = this
    // 创建一个 WebSocket 连接
    wx.connectSocket({
      url: 'ws://localhost:8888/wx/chat/1212',
    })

    // 监听 WebSocket 连接打开事件
    wx.onSocketOpen(function (res){

      // 通过 WebSocket 连接发送数据
      wx.sendSocketMessage({
        data: "Hello Spring WebSocket",
        success(){
          console.log("数据发送成功")
          // 监听 WebSocket 接受到服务器的消息事件
          wx.onSocketMessage(function(re){
            that.setData({ response: re.data})
            console.log("SocketMessage: "+re.data)
          })

        },
        fail(){
          console.log("数据发送失败")
        }
      })
    })
  },
  
})