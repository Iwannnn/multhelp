// pages/search/search.js
const app=getApp();

Page({
  data: {
    nbFrontColor: '#000000',
    nbBackgroundColor: '#fae4fa',
    canIGet:false,
    canIGetMore:true,
    pageNum: 1,
    callBackCount: 5,
    searchValue:"",
    tempSearchValue:"",
    miniposts:[],
  },
  onLoad:function(options) {
    this.setData({
      nbTitle: '搜索',
      nbLoading: false,
      pageNum: 1,
    })
  },
  getSearchValue:function(e){
    this.setData({
      tempSearchValue:e.detail.value
    })
  },
  searchButton:function(){
    this.setData({
      searchValue:this.data.tempSearchValue
    })
    this.search()
  },
  searchKeyBoard:function(){
    this.setData({
      searchValue:this.data.tempSearchValue
    })
    this.search()
  },
  search:function(){
    var that=this;
    var searchValue=this.data.searchValue;
    var nums=this.data.pageNum*this.data.callBackCount;
    wx.request({
      url: app.globalData.domain+'/wx/search',
      data:{
        searchValue:searchValue,
        nums:nums
      },
      success: request_res =>{
        console.log(request_res.data)
        that.setData({
          canIGet:true,
          miniposts:request_res.data,
        })
        console.log(that.data.miniposts)
      }
    })
  },
  onReachBottom: function () {
    var that=this;
    if(that.data.canIGetMore==true)  {
      var pageNum = that.data.pageNum + 1; //获取当前页数并+1
      that.setData({
        pageNum: pageNum, //更新当前页数
      })
      console.log(pageNum);
      that.search();
    }
  },
})