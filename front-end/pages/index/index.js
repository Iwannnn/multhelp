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
    interval: 5000,
    duration: 2000,
    pageNum: 1,
    callBackCount: 5,
    miniposts:[],
  },
  onLoad:function(options) {
    this.setData({
      nbTitle: '主页',
      nbLoading: false,
      pageIndex: 1,
    })
    this.getPosts();
  },
  onReachBottom: function () {
    var that=this;
    var pageNum = that.data.pageNum + 1; //获取当前页数并+1
    that.setData({
      pageNum: pageNum, //更新当前页数
    })
    console.log(pageNum);
    that.getPosts();
  },
  getPosts:function(){
    var that=this;
    // app.checkSession_3rd();
    var nums=that.data.pageNum*that.data.callBackCount;
    wx.request({
      url: app.globalData.domain + '/wx/post/getPosts',
      data:{
        nums:nums
      },
      success:request_res=>{
        console.log(request_res.data)
        that.setData({
          miniposts:request_res.data
        })
      }
    })
  },
  getPostDeatil:function(){
    app.checkSession_3rd();
    wx.request({
      url: app.globalData.domain + '/wx/post/getPostDeatil',
    })
  }
})
