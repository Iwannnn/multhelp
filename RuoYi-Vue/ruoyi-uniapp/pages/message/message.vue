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
	<view style="display:flex; flex-direction:column; min-height: 150px; padding: 10px; margin-bottom: 70px;">
		<!--pages/message/message.wxml-->
		<block v-for="(item, index) in messages" :key="index">
			<navigator :url="'chat/chat?chatid=' + item.chatid" style="display: flex;">
				<view class="avatar"><image class="avatar-size" :src="item.avatarUrl"></image></view>
				<view class="message">
					<view style="float: left;">
						<view style="color: #000000;font-size: 40rpx;">{{ item.nickName }}</view>
						<view style="color: #CCCCCC;font-size: 30rpx;">{{ item.lastContent }}</view>
					</view>
					<view style="margin-left: 150rpx;">
						<view style="color: #CCCCCC;font-size: 25rpx;">{{ item.lastContentTime }}</view>
						<text>\n</text>
						<view class="unread-circle" v-if="item.unread != '0'">
							<view class="unread-num">
							{{ item.unread }}
						</view>
						</view>
					</view>
				</view>
			</navigator>
			<view class="divLine"></view>
		</block>
	</view>
</template>

<script>
// pages/message/message.js
const app = getApp();

export default {
	data() {
		return {
			nbFrontColor: '#000000',
			nbBackgroundColor: '#fae4fa',
			messageSocket: null,
			messages: [],
			response: ''
		};
	},

	components: {},
	props: {},
	onLoad: function() {
		this.setData({
			nbTitle: '我的消息',
			nbLoading: false,
		});
		app.globalData.messageSocket.close();
		this.createWebSocket();
	},
	onShow: function() {
		app.globalData.checkSession_3rd();
		// this.getMessages();
	},
	methods: {
		createWebSocket: function() {
			//进入message页面后，message websocket有message页面接管 为了setdata实时渲染成功
			console.log(app.globalData.messageSocket);
			var that = this;
			this.messageSocket = uni.connectSocket({
				url: app.globalData.socket + '/wx/message/' + app.globalData.session_3rd,
				success: () => {}
			});
			console.log(this.messageSocket);
			this.messageSocket.onOpen(
				this.messageSocket.onMessage(function(res) {
					var messages = JSON.parse(res.data);
					console.log(res.data);
					that.setData({
						messages: messages
					});
				})
			);
		}
	}
};
</script>
<style>
/* pages/message/message.wxss */

.avatar {
	position: relative;
	margin: 20rpx 0rpx -100rpx 0rpx;
	float: left;
}

.avatar-size {
	width: 110rpx;
	height: 110rpx;
	border-radius: 10rpx;
}

.message {
	margin: 20rpx 20rpx -100rpx 20rpx;
	display: flex;
}

	
.unread-num{
	display: block;    
	color: #FFFFFF;
	font-weight: 1000;
	text-align: center;
}

.unread-circle {
	border-radius: 50%;
	height: 40rpx;
	width: 40rpx;
	display: inline-block;
	background: #f30303;
	vertical-align: top;
	float: right;
}

/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwTGdETHdLJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLCtCQUErQiIsImZpbGUiOiJ0by5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiBwYWdlcy9tZXNzYWdlL21lc3NhZ2Uud3hzcyAqLyJdfQ== */
</style>
