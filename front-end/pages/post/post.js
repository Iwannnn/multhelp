const { formatData } = require('../../utils/util.js');
// pages/post/post.js
var util=require('../../utils/util.js')
const app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    nbFrontColor: '#000000',
    nbBackgroundColor: '#fae4fa',
    categories: ['未分类', '交易类', '代替类', '资源类'],
    objectArray: [
      {
        id: 0,
        name: '未分类'
      },
      {
        id: 1,
        name: '交易类'
      },
      {
        id: 2,
        name: '代替类'
      },
      {
        id: 3,
        name: '资源类'
      }
    ],
    category_index: 0,
    tittle:"",
    detail:"",
    category:"",
    price:"",
    phone:"",
    destination_name:"",
    destination_address:"",
    address:"",
    need_date:Date,
    need_time:"00:00",
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var date = util.formatDate(new Date());
    var time = util.formatHM(new Date());
    this.setData({
      nbTitle: '发布',
      nbLoading: false,
      need_date:date,
      need_time:time
    })
  },
  titleInput:function(e){
    this.setData({
      tittle:e.detail.value
    })
  },
  detailTextArea:function (e) {
    this.setData({
      detail:e.detail.value
    })
  },
  bindPickerChange: function(e) {
    var category=this.data.categories[e.detail.value]
    this.setData({
      category_index: e.detail.value,
      category:category
    })
  },
  addressInput:function (e) {
    this.setData({
      address:e.detail.value
    })
  },
  "permission": {
    "scope.userLocation": {
      "desc": "你的位置信息将用于获取“地址”"
    }
  },
  getLocation: function () {
    var that = this;
    wx.chooseLocation({
      success: function (res) {
        that.setData({
          address:res.address+res.name
        })
      }
    })
  },
  priceInput:function (e) {
    this.setData({
      price: e.detail.value
    })
  },
  phoneInput:function (e) {
    this.setData({
      phone: e.detail.value
    })
  },
  bindDateChange: function (e) {
    this.setData({
      need_date: e.detail.value
    })
  },
  bindTimeChange: function (e) {
    this.setData({
      need_time: e.detail.value
    })
  },
  publishPost:function(){
    var that=this;
    app.checkSession_3rd();
    this.checkPost();
    wx.request({
      url: app.globalData.domain+'/wx/post/publishPost',
      method:'POST',
      data:{
        session_3rd:app.globalData.session_3rd, 
        tittle:that.data.tittle,
        detail:that.data.detail,
        category:that.data.category,
        price:that.data.price,
        phone:that.data.phone,
        address:that.data.address,
        need_time:that.data.need_date+" "+that.data.need_time+":00",
      },
      success:request_res=>{
        wx.showToast({
          title: '发布成功',
          duration: 1500,
          success: function () {
           //弹窗后执行，可以省略
            setTimeout(
              function () {
                wx.reLaunch({
                  url: '../index/index',
                })
              }, 
              1500
            );
          }
        })
      }
    })
  },
  checkPost:function(){
    if(this.data.title==""){this.showError("标题"); return false;}
    else if(this.data.detail==""){this.showError("详情"); return false;}
    else if(this.data.category=="" || this.data.category=="未分类"){this.showError("分类"); return false;}
    else if(this.data.price==""){this.showError("帮助金"); return false;}
    else if(this.data.phone==""){this.showError("电话"); return false;}
    return true;
  },
  showError:function(data){
    wx.showToast({
      title: data+'缺失',
      icon: 'error',
      duration: 1500,
    })
  }
})