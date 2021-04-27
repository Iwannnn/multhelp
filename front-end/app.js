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
        var that=this;
        if (res.code) {
            //发起网络请求
            wx.request({
              url:that.globalData.domain+'/wx/account/login',
              data: {
                code: res.code
              },
              success:request_res=>{
                this.globalData.session_3rd=request_res.data
              }
            })
            // console.log("login ok")
        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
    })
  },
  checkSession_3rd:function(){
    wx.request({
      url: this.globalData.domain+'/wx/session/checkSession_3rd',
      data:{
        session_3rd:this.globalData.session_3rd
      },
      success:request_res=>{
        if(request_res.data==false){
          wx.showToast({
            title: '会话过期需重载',
            icon: 'error',
            duration: 5000,
            success: function () {
             //弹窗后执行，可以省略
              setTimeout(
                function () {
                  wx.reLaunch({
                  url: '../index/index',
                  })
                }, 
                1500
              );
            }
          })
        }
      }
    })
  },
  globalData: {
    userInfo: null,
    domain: "http://localhost:8888",
    socket: "ws://localhost:8888",
    session_3rd: "",
},
})
