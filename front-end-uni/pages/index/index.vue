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
		<!--index.wxml-->

		<view>
			<swiper :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval" :duration="duration">
				<block v-for="(item, index) in background" :key="index">
					<swiper-item><image :src="item"></image></swiper-item>
				</block>
			</swiper>
		</view>
		<navigator url="../search/search">
			<view class="weui-search-bar">
				<view class="weui-search-bar__form">
					<view class="weui-search-bar__box">
						<icon class="weui-icon-search_in-box" type="search" size="14"></icon>
						<input type="text" class="weui-search-bar__input" placeholder="搜索" />
					</view>
				</view>
			</view>
		</navigator>
		<view class="box" style="width: 750rpx; height: 69rpx; display: block; box-sizing: border-box; left: 0rpx; top: 0rpx">
			<view
				:class="category_idx == 0 ? 'selected-box-container' : 'box-container'"
				style="width: 187rpx; height: 69rpx; display: flex; box-sizing: border-box; left: 0rpx; top: 0rpx; position: relative"
			>
				<view :class="category_idx == 0 ? 'selected-left' : 'left'" @tap="changetoAll">{{ category_list[0] }}</view>
			</view>
			<view
				:class="category_idx == 1 ? 'selected-box-container' : 'box-container'"
				style="width: 187rpx; height: 69rpx; display: flex; box-sizing: border-box; left: 187rpx; top: -69rpx; position: relative"
			>
				<view :class="category_idx == 1 ? 'selected-left' : 'left'" @tap="changetoSubstitute">{{ category_list[1] }}</view>
			</view>
			<view
				:class="category_idx == 2 ? 'selected-box-container' : 'box-container'"
				style="width: 187rpx; height: 69rpx; display: flex; box-sizing: border-box; left: 374rpx; top: -138rpx; position: relative"
			>
				<view :class="category_idx == 2 ? 'selected-left' : 'left'" @tap="changetoTransaction">{{ category_list[2] }}</view>
			</view>
			<view
				:class="category_idx == 3 ? 'selected-box-container' : 'box-container'"
				style="width: 187rpx; height: 69rpx; display: flex; box-sizing: border-box; left: 560rpx; top: -207rpx; position: relative"
			>
				<view :class="category_idx == 3 ? 'selected-left' : 'left'" @tap="changetoSource">{{ category_list[3] }}</view>
			</view>
		</view>
		<text>\n</text>
		<view v-if="canIGet">
			<view v-for="(item, index) in miniposts" :key="index">
				<navigator
					:url="'../detail/detail?postid=' + item.postid"
					class="weui-cell weui-cell_access"
					hover-class="weui-cell_active"
					style="display: flex; box-sizing: border-box; margin:auto; width: 95vw; height: 40vh;  border-radius: 30px;"
				>
					<view class="container-minipost" style="display: flex; box-sizing: border-box; margin:auto; width: 95vw; height: 40vh;">
						<text class="iconfont icon-biaoti" style="font-size:25px">标题 : {{ item.tittle }}</text>
						<text class="iconfont icon-leibie" style="font-size:20px">分类 : {{ item.category }}</text>
						<text class="iconfont icon-jine" style="font-size:20px">帮助金 : {{ item.price }}</text>
						<text class="iconfont icon-time" style="font-size:17px">发布时间 : {{ item.create_time }}</text>
						<text class="iconfont icon-jiezhishijian" style="font-size:17px">需求时间 : {{ item.need_time }}</text>
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
// index.js
// 获取应用实例
const app = getApp();

export default {
	data() {
		return {
			nbFrontColor: '#000000',
			nbBackgroundColor: '#fae4fa',
			background: ['http://47.98.63.97:8080/img/picture/asuka.png', 'http://47.98.63.97:8080/img/picture/xiaoxin.jpg', 'http://47.98.63.97:8080/img/picture/eva3.01.0.jpg'],
			indicatorDots: true,
			autoplay: true,
			interval: 5000,
			duration: 2000,
			canIGet: false,
			canIGetMore: true,
			pageNum: 1,
			callBackCount: 5,
			miniposts: [],
			category_list: ['全部', '代替类', '交易类', '资源类'],
			category_idx: 0,
			nbTitle: '',
			canGetMore: false,
			nbLoading: false
		};
	},

	components: {},
	props: {},
	onLoad: function(options) {
		this.setData({
			nbTitle: '主页',
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
		getPostsWithoutCategory: function() {
			var that = this; // app.checkSession_3rd();

			var nums = that.pageNum * that.callBackCount;
			uni.request({
				url: app.globalData.domain + '/wx/post/getPostsWithoutCategory',
				data: {
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
		},

		getPostsWithCategory() {
			var that = this; // app.checkSession_3rd();

			var nums = that.pageNum * that.callBackCount;
			var category = that.category_list[that.category_idx];
			console.log('get with category');
			uni.request({
				url: app.globalData.domain + '/wx/post/getPostsWithCategory',
				data: {
					category: category,
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
		},

		getPosts: function() {
			console.log(this.category_idx);
			if (this.category_idx == '0') this.getPostsWithoutCategory();
			else this.getPostsWithCategory();
		},
		changetoAll: function() {
			this.setData({
				category_idx: 0
			});
			this.initPostData();
			this.getPosts();
		},
		changetoSubstitute: function() {
			this.setData({
				category_idx: 1
			});
			this.initPostData();
			this.getPosts();
		},
		changetoTransaction: function() {
			this.setData({
				category_idx: 2
			});
			this.initPostData();
			this.getPosts();
		},
		changetoSource: function() {
			this.setData({
				category_idx: 3
			});
			this.initPostData();
			this.getPosts();
		},
		initPostData: function() {
			this.setData({
				canIGetMore: true,
				pageNum: 1,
				callBackCount: 5
			});
		}
	}
};
</script>
<style>
swiper {
	width: 100%;
	height: 400rpx;
}
swiper image {
	width: 100%;
	height: 100%;
}
.box {
	width: 100%;
	height: auto;
	background: #ffffff;
	display: inline-flex;
}

.box-container {
	height: 100rpx;
	align-items: center;
	font-weight: 500;
	background: #ffffff;
}
.selected-box-container {
	height: 100rpx;
	align-items: center;
	font-weight: 500;
	background: #ffffff;
	border-bottom: 7rpx solid #fae4fa;
}

.left {
	margin: auto;
	font-size: 30rpx;
}

.selected-left {
	margin: auto;
	font-size: 30rpx;
	color: #fae4fa;
}

/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwWkpHM2Z5JTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsV0FBVztFQUNYLGNBQWM7QUFDaEI7QUFDQTtFQUNFLFdBQVc7RUFDWCxZQUFZO0FBQ2Q7QUFDQTtFQUNFLFdBQVc7RUFDWCxZQUFZO0VBQ1osa0JBQWtCO0VBQ2xCLG1CQUFtQjtBQUNyQjs7QUFFQTtFQUNFLGNBQWM7RUFDZCxtQkFBbUI7RUFDbkIsZ0JBQWdCO0VBQ2hCLGtCQUFrQjtBQUNwQjtBQUNBO0VBQ0UsY0FBYztFQUNkLG1CQUFtQjtFQUNuQixnQkFBZ0I7RUFDaEIsa0JBQWtCO0VBQ2xCLGdDQUFnQztBQUNsQzs7O0FBR0E7RUFDRSxXQUFXO0VBQ1gsZ0JBQWdCO0FBQ2xCOztBQUVBO0VBQ0UsV0FBVztFQUNYLGdCQUFnQjtFQUNoQixjQUFjO0FBQ2hCIiwiZmlsZSI6InRvLmNzcyIsInNvdXJjZXNDb250ZW50IjpbInN3aXBlcntcclxuICB3aWR0aDogMTAwJTtcclxuICBoZWlnaHQ6IDQwMHJweDtcclxufVxyXG5zd2lwZXIgaW1hZ2V7XHJcbiAgd2lkdGg6IDEwMCU7XHJcbiAgaGVpZ2h0OiAxMDAlO1xyXG59XHJcbi5ib3h7XHJcbiAgd2lkdGg6IDEwMCU7XHJcbiAgaGVpZ2h0OiBhdXRvO1xyXG4gIGJhY2tncm91bmQ6I2ZmZmZmZjtcclxuICBkaXNwbGF5OmlubGluZS1mbGV4O1xyXG59XHJcbiBcclxuLmJveC1jb250YWluZXJ7XHJcbiAgaGVpZ2h0OiAxMDBycHg7XHJcbiAgYWxpZ24taXRlbXM6IGNlbnRlcjtcclxuICBmb250LXdlaWdodDogNTAwO1xyXG4gIGJhY2tncm91bmQ6I2ZmZmZmZjtcclxufVxyXG4uc2VsZWN0ZWQtYm94LWNvbnRhaW5lcntcclxuICBoZWlnaHQ6IDEwMHJweDtcclxuICBhbGlnbi1pdGVtczogY2VudGVyO1xyXG4gIGZvbnQtd2VpZ2h0OiA1MDA7XHJcbiAgYmFja2dyb3VuZDojZmZmZmZmO1xyXG4gIGJvcmRlci1ib3R0b206N3JweCBzb2xpZCAjZmFlNGZhO1xyXG59XHJcblxyXG4gXHJcbi5sZWZ0e1xyXG4gIG1hcmdpbjphdXRvO1xyXG4gIGZvbnQtc2l6ZTogMzBycHg7XHJcbn1cclxuIFxyXG4uc2VsZWN0ZWQtbGVmdHtcclxuICBtYXJnaW46YXV0bztcclxuICBmb250LXNpemU6IDMwcnB4O1xyXG4gIGNvbG9yOiAjZmFlNGZhO1xyXG59XHJcblxyXG4iXX0= */
</style>
