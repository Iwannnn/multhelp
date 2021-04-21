const app = getApp()
Page({
  data: {
    nbFrontColor: '#000000',
    nbBackgroundColor: '#fae4fa',
    userInfo: {},
    hasUserInfo: false
  },
  onLoad() {
    this.setData({
      nbTitle: '我的',
      nbLoading: false,
    }),
    this.canIUseProfile()
  },
  canIUseProfile:function(){
    var that=this;
    app.checkSession_3rd()
    wx.request({
      url:  app.globalData.domain +"/wx/account/checkUserProfile",
      data:{
        session_3rd:app.globalData.session_3rd
      },
      success: request_res => {
        if(request_res.data==false){
          that.setData({
            hasUserInfo: false
          })
        }else{
          that.setData({
            hasUserInfo: true
          })
          wx.request({
            url: app.globalData.domain + '/wx/account/getUserProfile',
            data:{
              session_3rd:app.globalData.session_3rd
            },
            success:request_res => {
              console.log(request_res.data)
              that.setData({
                userInfo:request_res.data
              })
            }
          })
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
        this.setUserProfile(profile_res.userInfo)
      }
    })
  },
  setUserProfile:function(userInfo){
    wx.request({
      url: app.globalData.domain+'/wx/account/updateUserProfile',
      method:'POST',
      data:{
        session_3rd:app.globalData.session_3rd,
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
  },
})