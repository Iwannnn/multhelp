// pages/post/post.js
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
    title:"",
    detail:"",
    category:"",
    price:"",
    phone:"",
    destination_name:"",
    destination_address:"",
    address:"",
    end_date:"2021-05-01",
    end_time:"00:00"
    
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      nbTitle: '发布',
      nbLoading: false,
    })
  },
  titleInput:function(e){
    this.setData({
      title:e.detail.value
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
      end_date: e.detail.value
    })
  },
  bindTimeChange: function (e) {
    this.setData({
      end_time: e.detail.value
    })
  },
})