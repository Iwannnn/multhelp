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
		<view style="display:flex; flex-direction:column; min-height: 300rpx; padding: 20rpx; margin-bottom: 140rpx;">
			<block v-for="(item, index) in contents" :key="index">
				<view v-if="item.sender == identity">
					<view>
						<view class="avatar-send"><image class="avatar-size" :src="myProfile.avatarUrl"></image></view>
						<view class="content-info-send">{{ myProfile.nickName }} {{ item.create_time }}</view>
						<view class="chat-my-send">{{ item.content }}</view>
					</view>
				</view>
				<view v-else>
					<view class="avatar-receive"><image class="avatar-size" :src="otherProfile.avatarUrl"></image></view>
					<view class="content-info-receive">{{ item.create_time }} {{ otherProfile.nickName }}</view>
					<view class="chat-my-receive">{{ item.content }}</view>
				</view>
			</block>
		</view>
		<view class="bottom">
			<view class="weui-message-bar">
				<view class="weui-message-bar__form">
					<view class="weui-message-bar__box">
						<input
							style="width: 708rpx; height: 78rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx"
							hold-keyboard="true"
							class="weui-message-bar__input"
							:value="content"
							@confirm="sendMessage"
							confirm-type="send"
							@input="getMessage"
						/>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
// pages/message/chat/chat.js
const app = getApp();

export default {
	data() {
		return {
			nbFrontColor: '#000000',
			nbBackgroundColor: '#fae4fa',
			postid: '',
			chatid: '',
			identity: 'initiator',
			content: '',
			contents: [],
			myProfile: {
				avatarUrl: '',
				nickName: ''
			},
			otherProfile: {
				avatarUrl: '',
				nickName: ''
			},
			test: [],
			chatSocket: null,
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
		var postid = options.postid;
		var chatid = options.chatid;
		this.setData({
			nbTitle: '聊天',
			nbLoading: false,
			postid: options.postid,
			chatid: options.chatid
		});
	},
	onShow: function() {
		app.globalData.checkSession_3rd();
		this.getAccount();
	},
	onUnload: function() {
		this.chatSocket.close();
	},
	methods: {
		createWebSocket: function() {
			var that = this;
			this.chatSocket = uni.connectSocket({
				url: app.globalData.socket + '/wx/chat/' + this.chatid,
				complete: () => {}
			});
			this.chatSocket.onOpen(
				this.chatSocket.onMessage(function(res) {
					console.log(res.data);
					var content = JSON.parse(res.data);

					if (content.sender != this.identity) {
						content.isRead = true;
						that.isRead(content.contentid);
					}

					that.contents = that.contents.concat(content);
					that.setData({
						contents: that.contents
					});
					that.srcollTo();
				})
			);

			// this.chatSocket.onSocketMessage(res => {
			// 	console.log(res.data);
			// 	var content = JSON.parse(res.data);

			// 	if (content.sender != this.identity) {
			// 		content.isRead = true;
			// 		this.isRead(content.contentid);
			// 	}

			// 	that.contents = that.contents.concat(content);
			// 	that.setData({
			// 		contents: that.contents
			// 	});
			// 	that.srcollTo();
			// });
		},
		getAccount: function() {
			var chatid = this.chatid;
			var postid = this.postid;

			if (chatid) {
				this.checkIdentity();
				this.createWebSocket();
				this.getOtherProfileByChatID();
				this.getPrevContents();
			}

			if (postid) {
				this.createChat();
				this.getOtherProfileByPostID();
			}
		},
		checkIdentity: function() {
			var that = this;
			uni.request({
				url: app.globalData.domain + '/wx/chat/checkIdentity',
				data: {
					chatid: that.chatid,
					session_3rd: app.globalData.session_3rd
				},
				success: request_res => {
					that.setData({
						identity: request_res.data
					});
				}
			});
		},
		getOtherProfileByPostID: function() {
			var that = this;
			var postid = this.postid;
			uni.request({
				url: app.globalData.domain + '/wx/account/getOtherProfileByPostID',
				data: {
					session_3rd: app.globalData.session_3rd,
					postid: postid
				},
				success: request_res => {
					that.setData({
						myProfile: request_res.data[0],
						otherProfile: request_res.data[1],
						nbTitle: request_res.data[1].nickName,
					});
				}
			});
		},
		getOtherProfileByChatID: function() {
			var that = this;
			var chatid = this.chatid;
			uni.request({
				url: app.globalData.domain + '/wx/account/getOtherProfileByChatID',
				data: {
					session_3rd: app.globalData.session_3rd,
					chatid: chatid
				},
				success: request_res => {
					that.setData({
						myProfile: request_res.data[0],
						otherProfile: request_res.data[1],
						nbTitle: request_res.data[1].nickName,
					});
				}
			});
		},
		createChat: function() {
			var that = this;
			var postid = this.postid;
			uni.request({
				url: app.globalData.domain + '/wx/chat/createChat',
				data: {
					session_3rd: app.globalData.session_3rd,
					postid: postid
				},
				success: request_res => {
					that.setData({
						chatid: request_res.data
					});
					that.checkIdentity();
					that.createWebSocket();
					that.getPrevContents();
				}
			});
		},
		getMessage: function(e) {
			this.setData({
				content: e.detail.value
			});
		},
		sendMessage: function() {
			var that = this;
			this.chatSocket.onOpen(
				this.chatSocket.send({
					data: app.globalData.session_3rd + ' ' + that.content
				})
			);
			// that.chatSocket.send({
			// 	data: app.globalData.session_3rd + ' ' + that.content
			// });
			// wx.sendSocketMessage({
			//   data:app.session_3rd+" "+that.data.content
			// })

			this.setData({
				content: ''
			});
		},
		getPrevContents: function() {
			var that = this;
			uni.request({
				url: app.globalData.domain + '/wx/chat/getPrevContents',
				data: {
					chatid: that.chatid
				},
				success: request_res => {
					console.log(request_res.data);
					var contents = request_res.data;

					for (var i = 0; i < contents.length; i++) {
						if (contents[i].sender != that.identity) {
							contents[i].isRead = true;
							this.isRead(contents[i].contentid);
							console.log('read');
						}
					}

					that.setData({
						contents: contents
					});
					that.srcollToStart();
				}
			});
		},
		srcollToStart: function() {
			setTimeout(() => {
				uni.pageScrollTo({ scrollTop: this.contents.length * 1000, duration: 0 });
			}, 0);
		},
		srcollTo: function() {
			setTimeout(() => {
				uni.pageScrollTo({ scrollTop: this.contents.length * 1000, duration: 300 });
			}, 0);
		},
		isRead: function(contentid) {
			uni.request({
				url: app.globalData.domain + '/wx/chat/isRead',
				data: {
					contentid: contentid
				}
			});
		}
	}
};
</script>
<style>
/* pages/message/chat/chat.wxss */

.weui-message-bar {
	position: relative;
	padding: 20rpx 20rpx 20rpx 20rpx;
	display: -webkit-box;
	display: -webkit-flex;
	display: flex;
	box-sizing: border-box;
	background-color: #eeeeee;
}

.weui-message-bar__form {
	bottom: 0rpx;
	position: relative;
	-webkit-box-flex: 1;
	-webkit-flex: auto;
	flex: auto;
	border-radius: 5rpx;
	background: #ffffff;
	border: 1rpx solid #ffffff;
}

.weui-message-bar__input {
	bottom: 0rpx;
	height: 35rpx;
	line-height: 35rpx;
	font-size: 30rpx;
}

.bottom {
	position: fixed;
	margin: 100rpx, 0rpx, 0rpx, 0rpx;
	bottom: 0rpx;
	width: 100%;
	height: 150rpx;
	background-color: #eeeeee;
}

.message {
	display: flex;
	flex-direction: row;
}

.content-container {
	margin-bottom: 100rpx;
}

.chat-my-receive {
	clear: both;
	position: relative;
	float: left;
	padding: 0rpx;
	color: #848484;
	background-color: #ffffff;
	margin: 50rpx 200rpx 20rpx 110rpx;
	padding: 20rpx 20rpx 20rpx 20rpx;
	border-radius: 7rpx;
	word-wrap: break-word;
	word-break: break-all;
	text-align: left;
}

.chat-my-receive:after {
	position: absolute;
	content: '';
	width: 0rpx;
	height: 0rpx;
	border-width: 10rpx 10rpx;
	border-style: solid;
	border-color: transparent #ffffff transparent transparent;
	top: 20rpx;
	right: 100%;
	margin-right: 0rpx;
}
.chat-my-send {
	clear: both;
	position: relative;
	float: right;
	padding: 0rpx;
	color: #848484;
	background-color: #b2e281;
	margin: 50rpx 110rpx 20rpx 200rpx;
	padding: 20rpx 20rpx 20rpx 20rpx;
	border-radius: 7rpx;
	word-wrap: break-word;
	word-break: break-all;
	text-align: left;
}

.chat-my-send:after {
	position: absolute;
	content: '';
	width: 0rpx;
	height: 0rpx;
	border-width: 10rpx 10rpx;
	border-style: solid;
	border-color: transparent transparent transparent #b2e281;
	top: 20rpx;
	left: 100%;
	margin-left: 0rpx;
}

.chat-notice {
	clear: both;
	font-size: 70%;
	color: white;
	text-align: center;
	margin-top: 15rpx;
	margin-bottom: 15rpx;
}
.chat-notice {
	background-color: #cecece;
	line-height: 25rpx;
	border-radius: 5rpx;
	padding: 5rpx 10rpx;
}

.avatar-size {
	width: 90rpx;
	height: 90rpx;
}

.avatar-send {
	position: relative;
	margin: 20rpx 10rpx -120rpx 200rpx;
	float: right;
}

.avatar-receive {
	position: relative;
	margin: 20rpx 200rpx -120rpx 10rpx;
	float: left;
}

.content-info-send {
	float: right;
	font-size: 20rpx;
	margin: 20rpx 110rpx -120rpx 10rpx;
}

.content-info-receive {
	float: left;
	font-size: 20rpx;
	margin: 20rpx 10rpx -120rpx 110rpx;
}

/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwTGdxQXd3JTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLGlDQUFpQzs7O0FBR2pDO0VBQ0Usa0JBQWtCO0VBQ2xCLGdDQUFnQztFQUNoQyxvQkFBb0I7RUFDcEIscUJBQXFCO0VBQ3JCLGFBQWE7RUFDYixzQkFBc0I7RUFDdEIseUJBQXlCO0FBQzNCOztBQUVBO0VBQ0UsV0FBVztFQUNYLGtCQUFrQjtFQUNsQixtQkFBbUI7RUFDbkIsa0JBQWtCO1VBQ1YsVUFBVTtFQUNsQixtQkFBbUI7RUFDbkIsbUJBQW1CO0VBQ25CLDBCQUEwQjtBQUM1Qjs7QUFFQTtFQUNFLFdBQVc7RUFDWCxhQUFhO0VBQ2Isa0JBQWtCO0VBQ2xCLGdCQUFnQjtBQUNsQjs7O0FBR0E7RUFDRSxlQUFlO0VBQ2YsOEJBQThCO0VBQzlCLFlBQVk7RUFDWixXQUFXO0VBQ1gsY0FBYztFQUNkLHlCQUF5QjtBQUMzQjs7QUFFQTtFQUNFLGFBQWE7RUFDYixtQkFBbUI7QUFDckI7O0FBRUE7RUFDRTtBQUNGOztBQUVBO0VBQ0UsVUFBVTtFQUNWLGtCQUFrQjtFQUNsQixXQUFXO0VBQ1gsYUFBYTtFQUNiLGNBQWM7RUFDZCx5QkFBeUI7RUFDekIsaUNBQWlDO0VBQ2pDLGdDQUFnQztFQUNoQyxrQkFBa0I7RUFDbEIscUJBQXFCO0VBQ3JCLHFCQUFxQjtFQUNyQixlQUFlO0FBQ2pCOztBQUVBO0VBQ0Usa0JBQWtCO0VBQ2xCLFdBQVc7RUFDWCxXQUFXO0VBQ1gsWUFBWTtFQUNaLHlCQUF5QjtFQUN6QixtQkFBbUI7RUFDbkIseURBQXlEO0VBQ3pELFVBQVU7RUFDVixXQUFXO0VBQ1gsa0JBQWtCO0FBQ3BCO0FBQ0E7RUFDRSxVQUFVO0VBQ1Ysa0JBQWtCO0VBQ2xCLFlBQVk7RUFDWixhQUFhO0VBQ2IsY0FBYztFQUNkLHlCQUF5QjtFQUN6QixpQ0FBaUM7RUFDakMsZ0NBQWdDO0VBQ2hDLGtCQUFrQjtFQUNsQixxQkFBcUI7RUFDckIscUJBQXFCO0VBQ3JCLGVBQWU7QUFDakI7OztBQUdBO0VBQ0Usa0JBQWtCO0VBQ2xCLFdBQVc7RUFDWCxXQUFXO0VBQ1gsWUFBWTtFQUNaLHlCQUF5QjtFQUN6QixtQkFBbUI7RUFDbkIseURBQXlEO0VBQ3pELFVBQVU7RUFDVixVQUFVO0VBQ1YsaUJBQWlCO0FBQ25COztBQUVBO0VBQ0UsV0FBVztFQUNYLGNBQWM7RUFDZCxZQUFZO0VBQ1osa0JBQWtCO0VBQ2xCLGlCQUFpQjtFQUNqQixvQkFBb0I7QUFDdEI7QUFDQTtFQUNFLHlCQUF5QjtFQUN6QixrQkFBa0I7RUFDbEIsbUJBQW1CO0VBQ25CLG1CQUFtQjtBQUNyQjs7QUFFQTtFQUNFLFlBQVksRUFBRSxhQUFhO0FBQzdCOztBQUVBO0VBQ0Usa0JBQWtCO0VBQ2xCLGtDQUFrQztFQUNsQyxZQUFZO0FBQ2Q7O0FBRUE7RUFDRSxrQkFBa0I7RUFDbEIsa0NBQWtDO0VBQ2xDLFdBQVc7QUFDYjs7QUFFQTtFQUNFLFlBQVk7RUFDWixnQkFBZ0I7RUFDaEIsa0NBQWtDO0FBQ3BDOztBQUVBO0VBQ0UsV0FBVztFQUNYLGdCQUFnQjtFQUNoQixrQ0FBa0M7QUFDcEMiLCJmaWxlIjoidG8uY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLyogcGFnZXMvbWVzc2FnZS9jaGF0L2NoYXQud3hzcyAqL1xyXG5cclxuXHJcbi53ZXVpLW1lc3NhZ2UtYmFyIHtcclxuICBwb3NpdGlvbjogcmVsYXRpdmU7XHJcbiAgcGFkZGluZzogMjBycHggMjBycHggMjBycHggMjBycHg7XHJcbiAgZGlzcGxheTogLXdlYmtpdC1ib3g7XHJcbiAgZGlzcGxheTogLXdlYmtpdC1mbGV4O1xyXG4gIGRpc3BsYXk6IGZsZXg7XHJcbiAgYm94LXNpemluZzogYm9yZGVyLWJveDtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjZWVlZWVlO1xyXG59XHJcblxyXG4ud2V1aS1tZXNzYWdlLWJhcl9fZm9ybSB7XHJcbiAgYm90dG9tOjBycHg7XHJcbiAgcG9zaXRpb246IHJlbGF0aXZlO1xyXG4gIC13ZWJraXQtYm94LWZsZXg6IDE7XHJcbiAgLXdlYmtpdC1mbGV4OiBhdXRvO1xyXG4gICAgICAgICAgZmxleDogYXV0bztcclxuICBib3JkZXItcmFkaXVzOiA1cnB4O1xyXG4gIGJhY2tncm91bmQ6ICNmZmZmZmY7XHJcbiAgYm9yZGVyOiAxcnB4IHNvbGlkICNmZmZmZmY7XHJcbn1cclxuXHJcbi53ZXVpLW1lc3NhZ2UtYmFyX19pbnB1dCB7XHJcbiAgYm90dG9tOjBycHg7XHJcbiAgaGVpZ2h0OiAzNXJweDtcclxuICBsaW5lLWhlaWdodDogMzVycHg7XHJcbiAgZm9udC1zaXplOiAzMHJweDtcclxufVxyXG5cclxuXHJcbi5ib3R0b217XHJcbiAgcG9zaXRpb246IGZpeGVkO1xyXG4gIG1hcmdpbjogMTAwcnB4ICwwcnB4LDBycHgsMHJweDtcclxuICBib3R0b206IDBycHg7XHJcbiAgd2lkdGg6IDEwMCU7XHJcbiAgaGVpZ2h0OiAxNTBycHg7XHJcbiAgYmFja2dyb3VuZC1jb2xvcjogI2VlZWVlZTtcclxufVxyXG5cclxuLm1lc3NhZ2V7XHJcbiAgZGlzcGxheTogZmxleDtcclxuICBmbGV4LWRpcmVjdGlvbjogcm93O1xyXG59XHJcblxyXG4uY29udGVudC1jb250YWluZXJ7XHJcbiAgbWFyZ2luLWJvdHRvbTogMTAwcnB4XHJcbn1cclxuXHJcbi5jaGF0LW15LXJlY2VpdmV7XHJcbiAgY2xlYXI6Ym90aDtcclxuICBwb3NpdGlvbjogcmVsYXRpdmU7XHJcbiAgZmxvYXQ6IGxlZnQ7XHJcbiAgcGFkZGluZzogMHJweDtcclxuICBjb2xvcjogIzg0ODQ4NDtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjZmZmZmZmO1xyXG4gIG1hcmdpbjogNTBycHggMjAwcnB4IDIwcnB4IDExMHJweDtcclxuICBwYWRkaW5nOiAyMHJweCAyMHJweCAyMHJweCAyMHJweDtcclxuICBib3JkZXItcmFkaXVzOjdycHg7XHJcbiAgd29yZC13cmFwOiBicmVhay13b3JkO1xyXG4gIHdvcmQtYnJlYWs6IGJyZWFrLWFsbDtcclxuICB0ZXh0LWFsaWduOmxlZnQ7XHJcbn1cclxuXHJcbi5jaGF0LW15LXJlY2VpdmU6YWZ0ZXJ7XHJcbiAgcG9zaXRpb246IGFic29sdXRlO1xyXG4gIGNvbnRlbnQ6ICcnO1xyXG4gIHdpZHRoOiAwcnB4O1xyXG4gIGhlaWdodDogMHJweDtcclxuICBib3JkZXItd2lkdGg6IDEwcnB4IDEwcnB4O1xyXG4gIGJvcmRlci1zdHlsZTogc29saWQ7XHJcbiAgYm9yZGVyLWNvbG9yOiB0cmFuc3BhcmVudCAjZmZmZmZmIHRyYW5zcGFyZW50IHRyYW5zcGFyZW50O1xyXG4gIHRvcDogMjBycHg7XHJcbiAgcmlnaHQ6IDEwMCU7XHJcbiAgbWFyZ2luLXJpZ2h0OiAwcnB4OyBcclxufVxyXG4uY2hhdC1teS1zZW5ke1xyXG4gIGNsZWFyOmJvdGg7XHJcbiAgcG9zaXRpb246IHJlbGF0aXZlO1xyXG4gIGZsb2F0OiByaWdodDtcclxuICBwYWRkaW5nOiAwcnB4O1xyXG4gIGNvbG9yOiAjODQ4NDg0O1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICNiMmUyODE7XHJcbiAgbWFyZ2luOiA1MHJweCAxMTBycHggMjBycHggMjAwcnB4O1xyXG4gIHBhZGRpbmc6IDIwcnB4IDIwcnB4IDIwcnB4IDIwcnB4O1xyXG4gIGJvcmRlci1yYWRpdXM6N3JweDtcclxuICB3b3JkLXdyYXA6IGJyZWFrLXdvcmQ7XHJcbiAgd29yZC1icmVhazogYnJlYWstYWxsO1xyXG4gIHRleHQtYWxpZ246bGVmdDtcclxufVxyXG5cclxuXHJcbi5jaGF0LW15LXNlbmQ6YWZ0ZXJ7XHJcbiAgcG9zaXRpb246IGFic29sdXRlO1xyXG4gIGNvbnRlbnQ6ICcnO1xyXG4gIHdpZHRoOiAwcnB4O1xyXG4gIGhlaWdodDogMHJweDtcclxuICBib3JkZXItd2lkdGg6IDEwcnB4IDEwcnB4O1xyXG4gIGJvcmRlci1zdHlsZTogc29saWQ7XHJcbiAgYm9yZGVyLWNvbG9yOiB0cmFuc3BhcmVudCB0cmFuc3BhcmVudCB0cmFuc3BhcmVudCAjYjJlMjgxO1xyXG4gIHRvcDogMjBycHg7XHJcbiAgbGVmdDogMTAwJTtcclxuICBtYXJnaW4tbGVmdDogMHJweDsgXHJcbn1cclxuXHJcbi5jaGF0LW5vdGljZXtcclxuICBjbGVhcjogYm90aDtcclxuICBmb250LXNpemU6IDcwJTtcclxuICBjb2xvcjogd2hpdGU7XHJcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG4gIG1hcmdpbi10b3A6IDE1cnB4O1xyXG4gIG1hcmdpbi1ib3R0b206IDE1cnB4O1xyXG59XHJcbi5jaGF0LW5vdGljZXtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjY2VjZWNlO1xyXG4gIGxpbmUtaGVpZ2h0OiAyNXJweDtcclxuICBib3JkZXItcmFkaXVzOiA1cnB4O1xyXG4gIHBhZGRpbmc6IDVycHggMTBycHg7XHJcbn1cclxuXHJcbi5hdmF0YXItc2l6ZXtcclxuICB3aWR0aDogOTBycHg7IGhlaWdodDogOTBycHg7IFxyXG59XHJcblxyXG4uYXZhdGFyLXNlbmR7XHJcbiAgcG9zaXRpb246IHJlbGF0aXZlO1xyXG4gIG1hcmdpbjogMjBycHggMTBycHggLTEyMHJweCAyMDBycHg7XHJcbiAgZmxvYXQ6IHJpZ2h0O1xyXG59XHJcblxyXG4uYXZhdGFyLXJlY2VpdmV7XHJcbiAgcG9zaXRpb246IHJlbGF0aXZlO1xyXG4gIG1hcmdpbjogMjBycHggMjAwcnB4IC0xMjBycHggMTBycHg7XHJcbiAgZmxvYXQ6IGxlZnQ7XHJcbn1cclxuXHJcbi5jb250ZW50LWluZm8tc2VuZHtcclxuICBmbG9hdDogcmlnaHQ7XHJcbiAgZm9udC1zaXplOiAyMHJweDtcclxuICBtYXJnaW46IDIwcnB4IDExMHJweCAtMTIwcnB4IDEwcnB4O1xyXG59XHJcblxyXG4uY29udGVudC1pbmZvLXJlY2VpdmV7XHJcbiAgZmxvYXQ6IGxlZnQ7XHJcbiAgZm9udC1zaXplOiAyMHJweDtcclxuICBtYXJnaW46IDIwcnB4IDEwcnB4IC0xMjBycHggMTEwcnB4O1xyXG59XHJcbiJdfQ== */
</style>
