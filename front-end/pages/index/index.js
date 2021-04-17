// index.js
// 获取应用实例
const app = getApp()
Page({
  data: {
    nbFrontColor: '#000000',
    nbBackgroundColor: '#ffffff',
    background: ['../../img/picture/asuka.png', '../../img/picture/xiaoxin.jpg', '../../img/picture/eva3.01.0.jpg'],
    indicatorDots: true,
    autoplay: true,
    interval: 2000,
    duration: 2000
  },
  onLoad:function(options) {
    this.setData({
      nbTitle: '主页',
      nbLoading: false,
      nbFrontColor: '#000000',
      nbBackgroundColor: '#ffffff',
    })
  },
})


