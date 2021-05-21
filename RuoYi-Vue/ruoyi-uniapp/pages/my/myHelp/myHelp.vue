<template>
	<page-meta>
		<navigation-bar
			:title="nbTitle"
			:front-color="nbFrontColor"
			:background-color="nbBackgroundColor"
			color-animation-duration="2000"
			color-animation-timing-func="easeIn"
		></navigation-bar>
	</page-meta>
	<view>
		<!--pages/my/myPost/myPost.wxml-->
		<view v-if="canIGet">
			<view v-for="(item, index) in miniposts" :key="index">
				<navigator
				:url="'detail/detail?postid=' + item.postid"
				class="weui-cell weui-cell_access"
				hover-class="weui-cell_active"
					style="display: flex; box-sizing: border-box; margin:auto; width: 95vw; height: 40vh;  border-radius: 30px;"
				>
					<view class="container-minipost" style="display: flex; box-sizing: border-box; margin:auto; width: 95vw; height: 40vh;">
						<text class="iconfont icon-biaoti" style="font-size:25px">标题 : {{ item.tittle }}</text>
						<text class="iconfont icon-jine" style="font-size:20px">帮助金 : {{ item.price }}</text>
						<text class="iconfont icon-time" style="font-size:17px">发布时间 : {{ item.create_time }}</text>
						<text class="iconfont icon-jiezhishijian" style="font-size:17px">需求时间 : {{ item.need_time }}</text>
						<text v-if="item.is_value == '0'" class="iconfont icon-time" style="font-size:17px">接单时间 : {{ item.end_time }}</text>
						<text class="iconfont icon-dizhi" style="font-size:17px">地址 : {{ item.address }}</text>
					</view>
				</navigator>
				<text>\n</text>
			</view>
			<view v-if="!canGetMore" style="text-align:centerx"><text style="position: relative; left: 218rpx; top: -24rpx">到到到到到底辣辣辣辣辣</text></view>
		</view>
		<view v-else><text>无法获取数据</text></view>
	</view>
</template>

<script>
// pages/my/myPost/myPost.js
const app = getApp();

export default {
	data() {
		return {
			nbFrontColor: '#000000',
			nbBackgroundColor: '#fae4fa',
			pageNum: 1,
			callBackCount: 5,
			canIGet: false,
			canIGetMore: true,
			miniposts: [],
			nbTitle: '',
			canGetMore: false,
			nbLoading: false
		};
	},

	components: {},
	props: {},
	onLoad: function(options) {
		this.setData({
			nbTitle: '我的帮助',
			nbLoading: false,
			pageNum: 1
		});
	},
	onShow: function(options) {
		this.getPosts();
	},
	onReachBottom: function() {
		var that = this;

		if (that.canIGetMore == true) {
			var pageNum = that.pageNum + 1; //获取当前页数并+1

			that.setData({
				pageNum: pageNum //更新当前页数
			});
			console.log(pageNum);
			that.getPosts();
		}
	},
	methods: {
		getPosts: function() {
			var that = this;
			app.globalData.checkSession_3rd();
			var nums = that.pageNum * that.callBackCount;
			uni.request({
				url: app.globalData.domain + '/wx/my/getHelps',
				data: {
					session_3rd: app.globalData.session_3rd,
					nums: nums
				},
				success: request_res => {
					console.log(request_res.data);
					that.setData({
						canIGet: true,
						miniposts: request_res.data
					});

					if (that.miniposts.length < nums) {
						that.setData({
							canIGetMore: false
						});
					}
				}
			});
		}
	}
};
</script>
<style>
/* pages/my/myPost/myPost.wxss */
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwTGNkVGc0JTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLGdDQUFnQyIsImZpbGUiOiJ0by5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiBwYWdlcy9teS9teVBvc3QvbXlQb3N0Lnd4c3MgKi8iXX0= */
</style>