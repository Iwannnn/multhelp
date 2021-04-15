// index.js
// 获取应用实例
// const app = getApp()

Page({
  data: {
    nbFrontColor: '#ffffff',
    nbBackgroundColor: '#f0f0ff',
  },
  onLoad() {
    this.setData({
      nbTitle: '主页',
      nbLoading: false,
      nbFrontColor: '#000000',
      nbBackgroundColor: '#f0f0ff',
    }),
    wx.login({
      success (res) {
        if (res.code) {
          //发起网络请求
          wx.request({
            url: 'https://test.c/onLogin',
            data: {
              code: res.code
            }
          })
        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
    })
  }
})


