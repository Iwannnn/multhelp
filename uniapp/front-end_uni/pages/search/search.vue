<template>
<view>
<!--pages/search/search.wxml-->
<page-meta style="fontsize: 25">
  <navigation-bar :title="nbTitle" :loading="nbLoading" :front-color="nbFrontColor" :background-color="nbBackgroundColor" color-animation-duration="2000" color-animation-timing-func="easeIn"></navigation-bar>
</page-meta>
<view>
  <view>
    <view class="weui-search-bar">
      <view class="weui-search-bar__form">
        <view class="weui-search-bar__box">
          <icon class="weui-icon-search_in-box" type="search" size="14"></icon>
          <input class="weui-search-bar__input" @confirm="searchKeyBoard" confirm-type="search" @input="getSearchValue" placeholder="请输入搜索内容">
        </view>
      </view>
      <view class="weui-search-bar__search-btn" @tap="searchButton">搜索</view>
    </view>
  </view>
</view>
<view v-if="canIGet">
  <view v-for="(item, index) in miniposts" :key="index">
    <navigator :url="'../detail/detail?postid=' + item.postid" class="weui-cell weui-cell_access" hover-class="weui-cell_active" style="display: flex; box-sizing: border-box; margin:auto; width: 95vw; height: 40vh;  border-radius: 30px;">
      <view class="container-minipost" style="display: flex; box-sizing: border-box; margin:auto; width: 95vw; height: 40vh;">
        <text class="iconfont icon-biaoti" style="font-size:25px"> 标题 : {{item.tittle}}</text>
        <text class="iconfont icon-leibie" style="font-size:20px"> 分类 : {{item.category}}</text>
        <text class="iconfont icon-jine" style="font-size:20px"> 帮助金 : {{item.price}}</text>
        <text class="iconfont icon-time" style="font-size:17px"> 发布时间 : {{item.create_time}}</text>
        <text class="iconfont icon-jiezhishijian" style="font-size:17px"> 需求时间 : {{item.need_time}}</text>
        <text class="iconfont icon-dizhi" style="font-size:17px"> 地址 : {{item.address}}</text>
      </view>
    </navigator>
    <text>\n</text>
  </view>
  <view v-if="!canGetMore" style="text-align:centerx">
  <text style="position: relative; left: 218rpx; top: -24rpx">到到到到到底辣辣辣辣辣</text>
  </view>
</view>
</view>
</template>

<script>
// pages/search/search.js
const app = getApp();

export default {
  data() {
    return {
      nbFrontColor: '#000000',
      nbBackgroundColor: '#fae4fa',
      canIGet: false,
      canIGetMore: true,
      pageNum: 1,
      callBackCount: 5,
      searchValue: "",
      tempSearchValue: "",
      miniposts: [],
      nbLoading: "",
      nbTitle: "",
      canGetMore: false
    };
  },

  components: {},
  props: {},
  onLoad: function (options) {
    this.setData({
      nbTitle: '搜索',
      nbLoading: false,
      pageNum: 1
    });
  },
  onReachBottom: function () {
    var that = this;

    if (that.canIGetMore == true) {
      var pageNum = that.pageNum + 1; //获取当前页数并+1

      that.setData({
        pageNum: pageNum //更新当前页数

      });
      console.log(pageNum);
      that.search();
    }
  },
  methods: {
    getSearchValue: function (e) {
      this.setData({
        tempSearchValue: e.detail.value
      });
    },
    searchButton: function () {
      this.setData({
        searchValue: this.tempSearchValue
      });
      this.search();
    },
    searchKeyBoard: function () {
      this.setData({
        searchValue: this.tempSearchValue
      });
      this.search();
    },
    search: function () {
      var that = this;
      var searchValue = this.searchValue;
      var nums = this.pageNum * this.callBackCount;
      uni.request({
        url: app.globalData.domain + '/wx/search',
        data: {
          searchValue: searchValue,
          nums: nums
        },
        success: request_res => {
          console.log(request_res.data);
          that.setData({
            canIGet: true,
            miniposts: request_res.data
          });
          console.log(that.miniposts);
        }
      });
    }
  }
};
</script>
