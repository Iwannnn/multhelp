<template>
<view>
<!--pages/my/myPost/detail/detail.wxml-->
<page-meta>
  <navigation-bar :title="nbTitle" :front-color="nbFrontColor" :background-color="nbBackgroundColor" color-animation-duration="2000" color-animation-timing-func="easeIn"></navigation-bar>
</page-meta>
<view class="container-ad" style="color:#f60309; position: relative; left: 0rpx;font-size:30px">
  <text>澳门网站: iwannnn.cn\n性感荷官在线为您服务</text>
</view>
<view class="container-detail">
    <text class="iconfont icon-biaoti" style="color:#001961;font-size:35px"> {{postDetail.tittle}}</text>
    <text class="iconfont icon-jine" style="color:#8a7c01; font-size:20px"> 帮助金 : {{postDetail.price}}</text>
    <text class="iconfont icon-time" style="color:#06663b; font-size:20px"> 发布时间 : {{postDetail.create_time}}</text>
    <text class="iconfont icon-jiezhishijian" style="color:#960310; font-size:20px"> 需求时间 : {{postDetail.need_time}}</text>
    <text v-if="postDetail.is_value=='0'" class="iconfont icon-jieshushijian" style="color:#960310; font-size:20px"> 结束时间 : {{postDetail.end_time}}</text>
    <text class="iconfont icon-bianhao" style="color:#7d7b7b; font-size:20px"> 编号 : {{postDetail.postid}}</text>
</view>
<view class="divLine-big"></view>
<view class="container-detail">
  <text class="iconfont icon-dizhi" style="color:#a15307; font-size:20px"> 地址 : {{postDetail.address}}</text>
</view>
<view class="divLine-big"></view>
<view class="container-detail" style="color:#430227; font-size:20px">
  <text class="iconfont icon-detail" style="font-size:25px"> 请求详情\n</text>
  {{postDetail.detail}}
</view>
<view class="divLine-big"></view>
<view class="container-detail">
  <view style="width: 642rpx; height: 122rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
    <image class="avatar" style="position: relative; left: 0rpx; top: 24rpx; width: 68rpx; height: 66rpx; display: inline-block; box-sizing: border-box" :src="publishUser.avatarUrl" mode="cover"></image>
    <text class="userinfo-nickname" style="color: #000000; position: relative; left: 94rpx; top: -47rpx; font-size: 20px">
      {{publishUser.nickName}}</text>
  </view>
  <text class="iconfont icon-xingming" style="color:#000000; font-size:20px"> 求助人</text>
  <text class="iconfont icon-gender gender" style="font-size:20px; color:#000000;">
    <text v-if="publishUser.gender=='0'"> 性别 : 其他</text>
    <text v-else-if="publishUser.gender=='1'"> 性别 : 男</text>
    <text v-else-if="publishUser.gender=='2'"> 性别 : 女</text>
    </text>  
</view>
<view class="divLine-big"></view>
<view class="container-detail">
  <view style="width: 642rpx; height: 122rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
    <image class="avatar" style="position: relative; left: 0rpx; top: 24rpx; width: 68rpx; height: 66rpx; display: inline-block; box-sizing: border-box" :src="receiveUser.avatarUrl" mode="cover"></image>
    <text class="userinfo-nickname" style="color: #000000; position: relative; left: 94rpx; top: -47rpx; font-size: 20px">
      {{receiveUser.nickName}}</text>
  </view>
  <text class="iconfont icon-xingming" style="color:#000000; font-size:20px"> 帮助人</text>
  <text class="iconfont icon-gender gender" style="color:#000000; font-size:20px">
    <text v-if="receiveUser.gender=='0'"> 性别 : 其他</text>
    <text v-else-if="receiveUser.gender=='1'"> 性别 : 男</text>
    <text v-else-if="receiveUser.gender=='2'"> 性别 : 女</text>
    </text>  
</view>
</view>
</template>

<script>
// pages/my/myPost/detail/detail.js
const app = getApp();

export default {
  data() {
    return {
      nbFrontColor: '#000000',
      nbBackgroundColor: '#fae4fa',
      postDetail: {
        tittle: "",
        price: "",
        create_time: "",
        need_time: "",
        end_time: "",
        is_value: "",
        postid: "",
        address: "",
        detail: ""
      },
      publishUser: {
        avatarUrl: "",
        nickName: "",
        gender: ""
      },
      receiveUser: {
        avatarUrl: "",
        nickName: "",
        gender: ""
      },
      postid: "",
      nbTitle: "",
      nbLoading: false
    };
  },

  components: {},
  props: {},
  onLoad: function (options) {
    var postid = options.postid;
    this.setData({
      nbTitle: '发布详情',
      nbLoading: false,
      postid: postid
    });
    this.getPostDetail();
  },
  methods: {
    getPostDetail: function (postid) {
      var that = this;
      postid = this.postid;
      uni.request({
        url: app.globalData.domain + '/wx/my/getPostDetail',
        data: {
          postid: postid
        },
        success: request_res => {
          that.setData({
            postDetail: request_res.data
          });
          console.log(this.postDetail);
        }
      });
      uni.request({
        url: app.globalData.domain + '/wx/my/getUsersProfile',
        data: {
          postid: postid
        },
        success: request_res => {
          that.setData({
            publishUser: request_res.data[0],
            receiveUser: request_res.data[1]
          });
          console.log(this.publishUser);
          console.log(this.receiveUser);
        }
      });
    }
  }
};
</script>
<style>
/* pages/my/myPost/detail/detail.wxss */
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwLTZxeTRDJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLHVDQUF1QyIsImZpbGUiOiJ0by5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiBwYWdlcy9teS9teVBvc3QvZGV0YWlsL2RldGFpbC53eHNzICovIl19 */
</style>