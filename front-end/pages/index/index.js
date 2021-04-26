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
    canIGet:false,
    canIGetMore:true,
    pageNum: 1,
    callBackCount: 5,
    miniposts:[],
    category_list:[
      '全部',
      '代替类',
      '交易类',
      '资源类'
    ],
    category_idx : 0
  },
  
  onLoad:function(options) {
    this.setData({
      nbTitle: '主页',
      nbLoading: false,
      pageIndex: 1,
    })
  },
  onShow:function(options){
    this.getPosts();
  },
  onReachBottom: function () {
    var that=this;
    if(that.data.canIGetMore==true)  {
      var pageNum = that.data.pageNum + 1; //获取当前页数并+1
      that.setData({
        pageNum: pageNum, //更新当前页数
      })
      console.log(pageNum);
      that.getPosts();
    }
  },
  getPostsWithoutCategory:function(){
    var that=this;
    // app.checkSession_3rd();
    var nums=that.data.pageNum*that.data.callBackCount;
    wx.request({
      url: app.globalData.domain + '/wx/post/getPostsWithoutCategory',
      data:{
        nums:nums
      },
      success:request_res=>{
        console.log(request_res.data)
        that.setData({
          canIGet:true,
          miniposts:request_res.data
        })
        if(that.data.miniposts.length<nums){
          that.setData({
            canIGetMore:false
          })
        }
      }
    })
  },
  getPostsWithCategory(){
    var that=this;
    // app.checkSession_3rd();
    var nums=that.data.pageNum*that.data.callBackCount;
    var category=that.data.category_list[that.data.category_idx]
    console.log("get with category")
    wx.request({
      url: app.globalData.domain + '/wx/post/getPostsWithCategory',
      data:{
        category:category,
        nums:nums,
      },
      success:request_res=>{
        console.log(request_res.data)
        that.setData({
          canIGet:true,
          miniposts:request_res.data
        })
        if(that.data.miniposts.length<nums){
          that.setData({
            canIGetMore:false
          })
        }
      }
    })
  },
  getPosts:function(){
    console.log(this.data.category_idx)
    if(this.data.category_idx=="0")
      this.getPostsWithoutCategory();
    else
      this.getPostsWithCategory();
  },
  changetoAll:function(){
    this.setData({
      category_idx:0
    })
    this.initPostData();
    this.getPosts();
  },
  changetoSubstitute:function(){
    this.setData({
      category_idx:1
    })
    this.initPostData();
    this.getPosts();
  },
  changetoTransaction:function(){
    this.setData({
      category_idx:2
    })
    this.initPostData();
    this.getPosts();
  },
  changetoSource:function(){
    this.setData({
      category_idx:3
    })
    this.initPostData();
    this.getPosts();
  },
  initPostData:function(){
    this.setData({
      canIGetMore:true,
      pageNum: 1,
      callBackCount: 5,
    })
  }
})
