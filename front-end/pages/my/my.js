const app = getApp()
Page({
  data: {
    nbFrontColor: '#000000',
    nbBackgroundColor: '#ffffff',
    userInfo: {},
    hasUserInfo: 'false'
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
    wx.request({
      url:  app.globalData.domain +"/wx/account/checkUserProfile",
      data:{
        code:app.globalData.code
      },
      success:function(res){
        if(res.data==false){
          that.setData({
            hasUserInfo: false
          })
        }else{
          that.setData({
            hasUserInfo: true
          })
          wx.request({
            url: app.globalData.domain+"/wx/account/getUserProfile",
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
      success: (res) => {
        console.log(res.userInfo);
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
        this.setUserProfile(res.userInfo)
      }
    })
  },
  setUserProfile:function(userInfo){
    wx.request({
      url: app.globalData.domain+'/wx/account/updateUserProfile',
      method:'POST',
      data:{
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