// index.js
// 获取应用实例
const app = getApp()
Page({
  data: {
    nbFrontColor: '#000000',
    nbBackgroundColor: '#fae4fa',
    background: ['http://47.98.63.97:8080/img/picture/asuka.png', 'http://47.98.63.97:8080/img/picture/xiaoxin.jpg', 'http://47.98.63.97:8080/img/picture/eva3.01.0.jpg'],
    indicatorDots: true,
    autoplay: true,
    interval: 2000,
    duration: 2000
  },
  onLoad:function(options) {
    this.setData({
      nbTitle: '主页',
      nbLoading: false,
    })
  },
})
