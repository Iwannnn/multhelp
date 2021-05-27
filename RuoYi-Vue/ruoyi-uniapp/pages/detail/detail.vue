<template>
	<view>
		<!--pages/detail/detail.wxml-->
		<page-meta>
			<navigation-bar
				:title="nbTitle"
				:front-color="nbFrontColor"
				:background-color="nbBackgroundColor"
				color-animation-duration="2000"
				color-animation-timing-func="easeIn"
			></navigation-bar>
		</page-meta>
		<view class="container-ad" style="color:#f60309; position: relative; left: 0rpx;font-size:30px"><text>澳门网站: iwannnn.cn\n性感站长在线为您服务</text></view>
		<view class="container-detail">
			<text class="iconfont icon-biaoti" style="color:#001961;font-size:35px">{{ postDetail.tittle }}</text>
			<view style="width: 642rpx; height: 122rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
				<image
					class="avatar"
					style="position: relative; left: 0rpx; top: 24rpx; width: 100rpx; height: 100rpx; display: inline-block; box-sizing: border-box"
					:src="postDetail.avatarUrl"
					mode="cover"
				></image>
				<text class="userinfo-nickname" style="color: #000000; position: relative; left: 80rpx; top:-5rpx; font-size: 50rpx">{{ postDetail.nickName }}</text>
			</view>
			<text class="iconfont icon-jine" style="color:#8a7c01; font-size:20px">帮助金 : {{ postDetail.price }}</text>
			<text class="iconfont icon-time" style="color:#06663b; font-size:20px">发布时间 : {{ postDetail.create_time }}</text>
			<text class="iconfont icon-jiezhishijian" style="color:#960310; font-size:20px">需求时间 : {{ postDetail.need_time }}</text>
		</view>
		<view class="divLine-big"></view>
		<view class="container-detail">
			<text class="iconfont icon-dizhi" style="color:#a15307; font-size:20px">地址 : {{ postDetail.address }}</text>
		</view>
		<view class="divLine-big"></view>
		<view class="container-detail" style="color:#430227; font-size:20px">
			<text class="iconfont icon-detail" style="font-size:25px"> 请求详情\n</text>
			{{ postDetail.detail }}
		</view>
		<view class="divLine-bottom"></view>
		<view class="bottom">
			<view class="action_btn">
				<button @tap="contact" class="btn_left">在线联系</button>
				<button @tap="helpPost" class="btn_right">我要帮忙</button>
			</view>
		</view>
	</view>
</template>

<script>
// pages/detail/detail.js
const app = getApp();

export default {
	data() {
		return {
			nbFrontColor: '#000000',
			nbBackgroundColor: '#fae4fa',
			postid: '',
			postDetail: '',
			nbTitle: '',
			nbLoading: false
		};
	},

	components: {},
	props: {},
	onLoad: function(options) {
		var postid = options.postid;
		this.setData({
			nbTitle: '求助详情',
			nbLoading: false,
			postid: postid
		});
		app.globalData.checkSession_3rd();
		this.getPostDetail();
	},
	methods: {
		getPostDetail: function() {
			var that = this;
			uni.request({
				url: app.globalData.domain + '/wx/post/getPostDetail',
				data: {
					postid: that.postid
				},
				success: request_res => {
					console.log(request_res.data);
					that.setData({
						postDetail: request_res.data
					});
				}
			});
		},
		helpPost: function() {
			var that = this;
			app.globalData.checkSession_3rd();
			console.log(app.globalData.session_3rd);
			console.log(that.postid);
			uni.request({
				url: app.globalData.domain + '/wx/post/helpPost',
				data: {
					session_3rd: app.globalData.session_3rd,
					postid: that.postid
				},
				success: request_res => {
					uni.showToast({
						icon:success,
						title:'接单成功'
					})
				},
			});
		},
		contact: function() {
			uni.navigateTo({
				url: '/pages/message/chat/chat?postid=' + this.postid
			});
		}
	}
};
</script>
<style>
/* pages/detail/detail.wxss */
page {
	display: block;
	min-height: 100%;
	background-color: #ffffff;
}

.double-view {
	display: flex;
	flex-flow: row nowrap;
	justify-content: space-between;
}

.bottom {
	display: flex;
	flex-direction: row;
	position: fixed;
	bottom: 0rpx;
	width: 100%;
	height: 120rpx;
	justify-content: space-around;
	background-color: #ffffff;
	align-content: center;
	align-items: center;
}

.action_btn {
	display: flex;
	flex-direction: row;
	justify-content: center;
	width: 75%;
	height: 80%;
	margin-left: 20rpx;
	margin-right: 20rpx;
	margin-top: 20rpx;
	margin-bottom: 0rpx;
}
.btn_left {
	background-color: #ff9900;
	width: 50%;
	height: 80%;
	font-size: 30rpx;
	color: #ffffff;
	border-bottom-left-radius: 50rpx;
	border-top-left-radius: 50rpx;
}
.btn_right {
	background-color: #ff3300;
	width: 50%;
	height: 80%;
	font-size: 30rpx;
	color: #ffffff;
	border-bottom-right-radius: 50rpx;
	border-top-right-radius: 50rpx;
}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwdVhoaXRtJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLDZCQUE2QjtBQUM3QjtFQUNFLGNBQWM7RUFDZCxnQkFBZ0I7RUFDaEIseUJBQXlCO0FBQzNCOztBQUVBO0VBQ0UsYUFBYTtFQUNiLHFCQUFxQjtFQUNyQiw4QkFBOEI7QUFDaEM7O0FBRUE7RUFDRSxhQUFhO0VBQ2IsbUJBQW1CO0VBQ25CLGVBQWU7RUFDZixZQUFZO0VBQ1osV0FBVztFQUNYLGNBQWM7RUFDZCw2QkFBNkI7RUFDN0IseUJBQXlCO0VBQ3pCLHFCQUFxQjtFQUNyQixtQkFBbUI7QUFDckI7O0FBRUE7RUFDRSxhQUFhO0VBQ2IsbUJBQW1CO0VBQ25CLHVCQUF1QjtFQUN2QixVQUFVO0VBQ1YsV0FBVztFQUNYLGtCQUFrQjtFQUNsQixtQkFBbUI7RUFDbkIsaUJBQWlCO0VBQ2pCLG1CQUFtQjtBQUNyQjtBQUNBO0VBQ0Usd0JBQXdCO0VBQ3hCLFVBQVU7RUFDVixXQUFXO0VBQ1gsZ0JBQWdCO0VBQ2hCLGNBQWM7RUFDZCxnQ0FBZ0M7RUFDaEMsNkJBQTZCO0FBQy9CO0FBQ0E7RUFDRSx3QkFBd0I7RUFDeEIsVUFBVTtFQUNWLFdBQVc7RUFDWCxnQkFBZ0I7RUFDaEIsY0FBYztFQUNkLGlDQUFpQztFQUNqQyw4QkFBOEI7QUFDaEMiLCJmaWxlIjoidG8uY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLyogcGFnZXMvZGV0YWlsL2RldGFpbC53eHNzICovXHJcbnBhZ2UgeyAgXHJcbiAgZGlzcGxheTogYmxvY2s7ICBcclxuICBtaW4taGVpZ2h0OiAxMDAlOyAgXHJcbiAgYmFja2dyb3VuZC1jb2xvcjogI2ZmZmZmZjsgIFxyXG59IFxyXG5cclxuLmRvdWJsZS12aWV3e1xyXG4gIGRpc3BsYXk6IGZsZXg7XHJcbiAgZmxleC1mbG93OiByb3cgbm93cmFwO1xyXG4gIGp1c3RpZnktY29udGVudDogc3BhY2UtYmV0d2VlbjtcclxufVxyXG5cclxuLmJvdHRvbXtcclxuICBkaXNwbGF5OiBmbGV4O1xyXG4gIGZsZXgtZGlyZWN0aW9uOiByb3c7XHJcbiAgcG9zaXRpb246IGZpeGVkO1xyXG4gIGJvdHRvbTogMHJweDtcclxuICB3aWR0aDogMTAwJTtcclxuICBoZWlnaHQ6IDEyMHJweDtcclxuICBqdXN0aWZ5LWNvbnRlbnQ6IHNwYWNlLWFyb3VuZDtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjZmZmZmZmO1xyXG4gIGFsaWduLWNvbnRlbnQ6IGNlbnRlcjtcclxuICBhbGlnbi1pdGVtczogY2VudGVyO1xyXG59XHJcblxyXG4uYWN0aW9uX2J0bntcclxuICBkaXNwbGF5OiBmbGV4O1xyXG4gIGZsZXgtZGlyZWN0aW9uOiByb3c7XHJcbiAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XHJcbiAgd2lkdGg6IDc1JTtcclxuICBoZWlnaHQ6IDgwJTtcclxuICBtYXJnaW4tbGVmdDogMjBycHg7XHJcbiAgbWFyZ2luLXJpZ2h0OiAyMHJweDtcclxuICBtYXJnaW4tdG9wOiAyMHJweDtcclxuICBtYXJnaW4tYm90dG9tOiAwcnB4O1xyXG59XHJcbi5idG5fbGVmdHtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiNmZjk5MDA7XHJcbiAgd2lkdGg6IDUwJTtcclxuICBoZWlnaHQ6IDgwJTtcclxuICBmb250LXNpemU6IDMwcnB4O1xyXG4gIGNvbG9yOiAjZmZmZmZmO1xyXG4gIGJvcmRlci1ib3R0b20tbGVmdC1yYWRpdXM6IDUwcnB4O1xyXG4gIGJvcmRlci10b3AtbGVmdC1yYWRpdXM6IDUwcnB4O1xyXG59XHJcbi5idG5fcmlnaHR7XHJcbiAgYmFja2dyb3VuZC1jb2xvcjojZmYzMzAwO1xyXG4gIHdpZHRoOiA1MCU7XHJcbiAgaGVpZ2h0OiA4MCU7XHJcbiAgZm9udC1zaXplOiAzMHJweDtcclxuICBjb2xvcjogI2ZmZmZmZjtcclxuICBib3JkZXItYm90dG9tLXJpZ2h0LXJhZGl1czogNTBycHg7XHJcbiAgYm9yZGVyLXRvcC1yaWdodC1yYWRpdXM6IDUwcnB4O1xyXG59Il19 */
</style>
