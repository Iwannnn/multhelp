// index.js
// 获取应用实例
// const app = getApp()
Page({
  data: {
    nbFrontColor: '#ffffff',
    nbBackgroundColor: '#f0f0ff',
    helloworld:[],
    post:'sss'
  },
  onLoad:function(options) {
    this.setData({
      nbTitle: '主页',
      nbLoading: false,
      nbFrontColor: '#000000',
      nbBackgroundColor: '#f0f0ff',
    })
    //this.getdata()
  },
  getdata:function(){
    var that= this;
    wx.request({
      url: 'http://localhost:8080/test/hello',
      success(res){
        that.setData({
          helloworld:res.data,
        })
      }
    })
  },
  postdata:function(){
    var that=this
    wx.request({
      url: 'http://localhost:8080//test/hello',
      method :'POST',
      data:{
        x: '1',
        y: '2'
      },
      success(res){
        console.log(res)
      }
    })
  },
  formSubmit:function (e){
    if (e.detail.value.name.length == 0 || e.detail.value.name.length >= 8) {
      wx.showToast({
        title: '姓名不能为空或过长!',
        icon: 'loading',
        duration: 1500
      })
      setTimeout(function () {
        wx.hideToast()
      }, 2000)
    } else {
      wx.request({
        url: 'http://localhost:8080/wx/account_info',
        data:{
          name:e.detail.value.name,
        },
        method:'POST',
        success:function(res){
          console.log(res.data)
        }
      })
    }
  }
})


