// pages/my/myPost/detail/detail.js
const app=getApp();

Page({
  data: {
    nbFrontColor: '#000000',
    nbBackgroundColor: '#fae4fa',
    postDetail:{},
    publishUser:{},
    receiveUser:{},
    postid:"",
  },
  onLoad: function (options) {
    var postid=options.postid;
    this.setData({
      nbTitle: '发布详情',
      nbLoading: false,
      postid:postid,
    })
    this.getPostDetail()
  },
  getPostDetail:function(postid){
    var that=this;
    postid=this.data.postid
    wx.request({
      url: app.globalData.domain+ '/wx/my/getPostDetail',
      data:{
        postid:postid
      },
      success:request_res=>{
        that.setData({
          postDetail:request_res.data
        })
        console.log(this.data.postDetail)
      }
    })
    wx.request({
      url: app.globalData.domain+ '/wx/my/getUsersProfile',
      data:{
        postid:postid
      },
      success:request_res=>{
        that.setData({
          publishUser:request_res.data[0],
          receiveUser:request_res.data[1]
        })
        console.log(this.data.publishUser)
        console.log(this.data.receiveUser)
      }
    })
  },
})