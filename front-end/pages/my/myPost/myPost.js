// pages/my/myPost/myPost.js
const app=getApp()

Page({
  data:{
    nbFrontColor: '#000000',
    nbBackgroundColor: '#fae4fa',
    pageNum: 1,
    callBackCount: 5,
    canIGet:false,
    canIGetMore:true,
    miniposts:[],
  },
  onLoad:function(options) {
    this.setData({
      nbTitle: '我的发布',
      nbLoading: false,
      pageNum: 1,
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
  getPosts:function(){
    var that=this;
    app.checkSession_3rd();
    var nums=that.data.pageNum*that.data.callBackCount;
    wx.request({
      url: app.globalData.domain + '/wx/my/getPosts',
      data:{
        session_3rd:app.globalData.session_3rd,
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
})