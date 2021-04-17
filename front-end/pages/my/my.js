const app = getApp()

Page({
  data: {
    nbFrontColor: '#000000',
    nbBackgroundColor: '#ffffff',
    
  },
  onLoad() {
    this.setData({
      nbTitle: '我的',
      nbLoading: false,
      nbFrontColor: '#000000',
      nbBackgroundColor: '#ffffff',
    })
  },
  login_button:function(){
  }
})