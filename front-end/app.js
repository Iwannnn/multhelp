// app.js

App({
  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
    var that=this
    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        if (res.code) {
            //发起网络请求
            wx.request({
              url:'http://localhost:8080/wx/account/login',
              data: {
                code: res.code
              },
            })
            this.globalData.code=res.code
            // console.log("login ok")
        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
    })
  },
  globalData: {
      userInfo: null,
      domain: "http://localhost:8080",
      code:"",
  }
})
