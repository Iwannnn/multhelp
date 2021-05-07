<template>
	<view>
		<!--pages/message/message.wxml-->
		<text>pages/message/message.wxml</text>
		<text>{{ response }}</text>
	</view>
</template>

<script>
// pages/message/message.js
const app = getApp();

export default {
	data() {
		return {
			messageSocket: null,
			messages: [],
			response: ''
		};
	},

	components: {},
	props: {},
	onLoad: function() {
		this.createWebSocket();
	},
	onShow: function() {
		app.globalData.checkSession_3rd();
	},
	methods: {
		createWebSocket: function() {
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

			// this.socketTask.onSokcetOpen(res => {
			// 	this.messageSocket.onSocketMessage(res => {
			// 		var messages = JSON.parse(res.data);
			// 		console.log(res.data);
			// 		that.setData({
			// 			messages: messages
			// 		});
			// 	});
			// });
		}
	}
};
</script>
<style>
/* pages/message/message.wxss */
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwTGdETHdLJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLCtCQUErQiIsImZpbGUiOiJ0by5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiBwYWdlcy9tZXNzYWdlL21lc3NhZ2Uud3hzcyAqLyJdfQ== */
</style>
