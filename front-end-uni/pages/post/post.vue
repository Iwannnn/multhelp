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
		<!--pages/post/post.wxml-->
		<view class="container">
			<view style="width: 750rpx; height: 100rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
				<text style="position: relative; left: 50rpx; top: 30rpx; font-size: 17px">标题</text>
				<input
					style="position: relative; width: 460rpx; height: 44rpx; left: 230rpx; top: -16rpx; font-size: 17px; display: block; box-sizing: border-box"
					@blur="titleInput"
					class="weui-input"
					placeholder="请输入求助的标题"
				/>
			</view>
			<view class="divLine"></view>
			<view style="width: 750rpx; height: 260rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
				<textarea
					style="width: 700rpx; height: 200rpx; display: block; position: relative; font-size: 17px; margin: auto; box-sizing: border-box; left: 0rpx; top: 30rpx"
					@blur="detailTextArea"
					placeholder="请在这里为你的求助进行详细的描述，比如在时间，具体事项。"
				></textarea>
			</view>
			<view class="divLine"></view>
			<view style="width: 750rpx; height: 100rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
				<text style="position: relative; left: 50rpx; top: 30rpx; font-size: 17px">分类</text>
				<picker
					@change="bindPickerChange"
					:value="category_index"
					:range="categories"
					style="position: relative; width: 460rpx; height: 44rpx; left: 230rpx; top: -16rpx; font-size: 17px; "
				>
					<view class="picker" style="width: 440rpx; height: 44rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
						{{ categories[category_index] }}
					</view>
				</picker>
			</view>
			<view class="divLine"></view>
			<view style="width: 750rpx; height: 100rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
				<text style="position: relative; left: 50rpx; top: 30rpx; font-size: 17px">地址</text>
				<input
					style="position: relative; width: 376rpx; height: 44rpx; left: 230rpx; top: -16rpx; font-size: 17px; display: block; box-sizing: border-box"
					@blur="addressInput"
					class="weui-input"
					placeholder="大概描述地址(可不输入)"
					:value="address"
				/>
				<button class="btn" @tap="getLocation" size="mini" style="position: relative; margin: auto; left: 606rpx; top: -74rpx">获取</button>
			</view>
			<view class="divLine"></view>
			<view style="width: 750rpx; height: 100rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
				<text style="position: relative; left: 50rpx; top: 30rpx; font-size: 17px">帮助金￥</text>
				<input
					style="position: relative; width: 498rpx; height: 44rpx; left: 230rpx; top: -16rpx; font-size: 17px; display: block; box-sizing: border-box"
					type="digit"
					class="weui-input"
					@blur="priceInput"
					placeholder="请输入愿意支付的帮助金(可为0)"
				/>
			</view>
			<view class="divLine"></view>
			<view style="width: 750rpx; height: 100rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
				<text style="position: relative; left: 50rpx; top: 30rpx; font-size: 17px">电话</text>
				<input
					style="position: relative; width: 460rpx; height: 44rpx; left: 230rpx; top: -15rpx; font-size: 17px; display: block; box-sizing: border-box"
					type="number"
					class="weui-input"
					@blur="phoneInput"
					placeholder="请输入手机号码"
				/>
				<!-- <button open-type="getPhoneNumber" bindgetphonenumber="getPhoneNumber" class="btn" style="position: relative; left: 44rpx; top: -39rpx">授权电话号码</button> -->
			</view>
			<view class="divLine"></view>
			<view class="section" style="width: 750rpx; height: 100rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
				<text style="position: relative; left: 50rpx; top: 30rpx; font-size: 17px">需求日期</text>
				<picker
					style="position: relative; width: 220rpx; height: 44rpx; left: 230rpx; top: -16rpx; font-size: 17px; display: block; box-sizing: border-box"
					mode="date"
					:value="need_date"
					:start="need_date"
					end="2031-05-01"
					@change="bindDateChange"
				>
					<view class="picker" style="width: 450rpx; height: 44rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">{{ need_date }}</view>
				</picker>
			</view>
			<view class="divLine"></view>
			<view class="section" style="width: 750rpx; height: 100rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
				<text style="position: relative; left: 50rpx; top: 30rpx; font-size: 17px">需求时间</text>
				<picker
					style="position: relative; width: 104rpx; height: 44rpx; left: 230rpx; top: -16rpx; font-size: 17px; display: block; box-sizing: border-box"
					mode="time"
					:value="need_time"
					:start="need_time"
					end="23:59"
					@change="bindTimeChange"
				>
					<view class="picker" style="width: 444rpx; height: 44rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">{{ need_time }}</view>
				</picker>
			</view>
			<view class="divLine"></view>
			<view style="position: relative; width: 706rpx; height: 90rpx; display: block; box-sizing: border-box; left: 22rpx; top: -1rpx">
				<text style="position: relative;font-size: 10px;margin:auto;">注：由于是个人账号无法实现微信认证，调用不了获取电话号码的接口就只好手动输入了</text>
			</view>
			<button class="btn-big" @tap="publishPost" style="position: relative; left: -1rpx; top: 58rpx; width: 600rpx; display: block; box-sizing: border-box">提交发布</button>
		</view>
	</view>
</template>

<script>
const { formatData } = require('../../utils/util.js'); // pages/post/post.js
// pages/post/post.js
var util = require('../../utils/util.js');
const app = getApp();

export default {
	data() {
		return {
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
			tittle: '',
			detail: '',
			category: '',
			price: '',
			phone: '',
			destination_name: '',
			destination_address: '',
			address: '',
			need_date: Date,
			need_time: '00:00',
			permission: {
				'scope.userLocation': {
					desc: '你的位置信息将用于获取“地址”'
				}
			},
			nbTitle: '',
			nbLoading: false
		};
	},

	components: {},
	props: {},

	/**
	 * 生命周期函数--监听页面加载
	 */
	onLoad: function(options) {
		var date = util.formatDate(new Date());
		var time = util.formatHM(new Date());
		this.setData({
			nbTitle: '发布',
			nbLoading: false,
			need_date: date,
			need_time: time
		});
	},
	methods: {
		titleInput: function(e) {
			this.setData({
				tittle: e.detail.value
			});
		},
		detailTextArea: function(e) {
			this.setData({
				detail: e.detail.value
			});
		},
		bindPickerChange: function(e) {
			var category = this.categories[e.detail.value];
			this.setData({
				category_index: e.detail.value,
				category: category
			});
		},
		addressInput: function(e) {
			this.setData({
				address: e.detail.value
			});
		},
		getLocation: function() {
			var that = this;
			uni.chooseLocation({
				success: function(res) {
					that.setData({
						address: res.address + res.name
					});
				}
			});
		},
		priceInput: function(e) {
			this.setData({
				price: e.detail.value
			});
		},
		phoneInput: function(e) {
			this.setData({
				phone: e.detail.value
			});
		},
		bindDateChange: function(e) {
			this.setData({
				need_date: e.detail.value
			});
		},
		bindTimeChange: function(e) {
			this.setData({
				need_time: e.detail.value
			});
		},
		publishPost: function() {
			var that = this;
			app.globalData.checkSession_3rd();
			this.checkPost();
			uni.request({
				url: app.globalData.domain + '/wx/post/publishPost',
				method: 'POST',
				data: {
					session_3rd: app.globalData.session_3rd,
					tittle: that.tittle,
					detail: that.detail,
					category: that.category,
					price: that.price,
					phone: that.phone,
					address: that.address,
					need_time: that.need_date + ' ' + that.need_time + ':00'
				},
				success: request_res => {
					uni.showToast({
						title: '发布成功',
						duration: 1500,
						success: function() {
							//弹窗后执行，可以省略
							setTimeout(function() {
								uni.reLaunch({
									url: '../index/index'
								});
							}, 1500);
						}
					});
				}
			});
		},
		checkPost: function() {
			if (this.title == '') {
				this.showError('标题');
				return false;
			} else if (this.detail == '') {
				this.showError('详情');
				return false;
			} else if (this.category == '' || this.category == '未分类') {
				this.showError('分类');
				return false;
			} else if (this.price == '') {
				this.showError('帮助金');
				return false;
			} else if (this.phone == '') {
				this.showError('电话');
				return false;
			}

			return true;
		},
		showError: function(data) {
			uni.showToast({
				title: data + '缺失',
				icon: 'error',
				duration: 1500
			});
		}
	}
};
</script>
<style>
/* pages/post/post.wxss */
page {
	display: block;
	min-height: 100%;
	background-color: #ffffff;
}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwUkZ0ekFSJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLHlCQUF5QjtBQUN6QjtFQUNFLGNBQWM7RUFDZCxnQkFBZ0I7RUFDaEIseUJBQXlCO0FBQzNCIiwiZmlsZSI6InRvLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi8qIHBhZ2VzL3Bvc3QvcG9zdC53eHNzICovXHJcbnBhZ2UgeyAgXHJcbiAgZGlzcGxheTogYmxvY2s7ICBcclxuICBtaW4taGVpZ2h0OiAxMDAlOyAgXHJcbiAgYmFja2dyb3VuZC1jb2xvcjogI2ZmZmZmZjsgIFxyXG59ICJdfQ== */
</style>
