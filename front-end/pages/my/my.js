const app = getApp()
Page({
  data: {
    nbFrontColor: '#000000',
    nbBackgroundColor: '#ffffff',
    userInfo: {},
    hasUserInfo: false
  },
  onLoad() {
    this.setData({
      nbTitle: '我的',
      nbLoading: false,
      nbFrontColor: '#000000',
      nbBackgroundColor: '#ffffff',
    }),
    this.canIUseProfile()
  },
  canIUseProfile:function(){
    var that=this;
    wx.login({
      success: login_res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        if (login_res.code) {
          wx.request({
            url:  app.globalData.domain +"/wx/account/checkUserProfile",
            data:{
              code:login_res.code
            },
            success: request_res => {
              console.log(request_res.data)
              if(request_res.data==false){
                that.setData({
                  hasUserInfo: false
                })
              }else{
                that.setData({
                  hasUserInfo: true
                })
                wx.login({
                  success: login_res => {
                    wx.request({
                      url: app.globalData.domain + '/wx/account/getUserProfile',
                      data:{
                        code:login_res.code
                      },
                      success:request_res => {
                        console.log(request_res.data)
                        that.setData({
                          userInfo:request_res.data
                        })
                      }
                    })
                  }
                })
              }
            }
          })
        } else {
          console.log('登录失败！' + login_res.errMsg)
        }
      }
    })
  },
  getUserProfile:function() {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认
    // 开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '用于完善会员资料', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (profile_res) => {
        console.log(profile_res.userInfo);
        this.setData({
          userInfo: profile_res.userInfo,
          hasUserInfo: true
        })
        wx.login({
          success: login_res => {
            // 发送 res.code 到后台换取 openId, sessionKey, unionId
            if (login_res.code) {
              this.setUserProfile(login_res.code,profile_res.userInfo)
            } else {
              console.log('登录失败！' + res.errMsg)
            }
          }
        })
      }
    })
  },
  setUserProfile:function(code,userInfo){
    console.log(code,userInfo)
    wx.request({
      url: app.globalData.domain+'/wx/account/updateUserProfile',
      method:'POST',
      data:{
        code:code,
        avatarUrl: userInfo.avatarUrl,
        city: userInfo.city,
        country: userInfo.country,
        gender: userInfo.gender,
        language: userInfo.language,
        nickName: userInfo.nickName,
        province: userInfo.province,
      },
      success:function(res){
        console.log("保存成功")
      }
    })
  }
})