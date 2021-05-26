<script>
export default {
	onLaunch() {
		// 展示本地存储能力
		const logs = uni.getStorageSync('logs') || [];
		logs.unshift(Date.now());
		uni.setStorageSync('logs', logs);
		var that = this; // 登录
		
		uni.login({
			success: res => {
				// 发送 res.code 到后台换取 openId, sessionKey, unionId
				var that = this;
				if (res.code) {
					//发起网络请求
					uni.request({
						url: that.$options.globalData.domain + '/wx/account/login',
						data: {
							code: res.code
						},
						success: request_res => {
							that.$options.globalData.session_3rd = request_res.data;
							that.$options.globalData.messageSocket = uni.connectSocket({
								url: that.$options.globalData.socket + '/wx/message/' + that.$options.globalData.session_3rd,
								success: () => {}
							});
							// console.log(that.$options.globalData.messageSocket);
							that.$options.globalData.messageSocket.onOpen(
								that.$options.globalData.messageSocket.onMessage(function(res) {
									var messages = JSON.parse(res.data);
									// console.log(res.data);
									that.$options.globalData.messages=res.data
									// console.log(that.$options.globalData.messages)
								})
							);
						}
					}); // console.log("login ok")
				} else {
					console.log('登录失败！' + res.errMsg);
				}
			}
		});
		
	},

	globalData: {
		checkSession_3rd: function() {
			var that = this;
			uni.request({
				url: getApp().globalData.domain + 'wx/session/checkSession_3rd',
				data: {
					session_3rd: getApp().globalData.session_3rd
				},
				success: request_res => {
					if (request_res.data == false) {
						uni.showToast({
							title: '会话过期需重载',
							icon: 'error',
							duration: 5000,
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
				}
			});
		},
		userInfo: null,
		domain: 'http://iwannnn.cn/prod-api/',
		socket: 'http://iwannnn.cn/prod-api/',
		session_3rd: '',
		messageSocket: null,
		messages: [],
		chats: []
	},
	methods: {}
};
</script>
<style lang="scss">
/**app.wxss**/

	/* 注意要写在第一行，同时给style标签加入lang="scss"属性 */
@import "uview-ui/index.scss";
@import 'style/wxbootstrap';
@import 'style/iconfont';
page {
	display: block;
	min-height: 100%;
	background-color: #f9f9f9;
}

.container {
	display: flex;
	flex-direction: column;
	align-items: left;
	justify-content: space-between;
	padding: 100 0;
	box-sizing: border-box;
	background: #ffffff;
}

.divLine {
	background: #e0e3da;
	margin: auto;
	width: 94%;
	height: 1rpx;
}

.divLine-big {
	background: #f0f0f0;
	margin: auto;
	width: 100%;
	height: 20rpx;
}

.divLine-bottom {
	background: #f0f0f0;
	margin: auto;
	width: 100%;
	height: 140rpx;
}

.avatar {
	border-radius: 25px;
}

.btn {
	border: 2px solid #f6d5f9;
	border-radius: 5px;
	background-color: white;
	font-size: 13px;
	color: #f6d5f9;
}

.btn::after {
	border: none;
}

.btn-big {
	border: none;
	border-radius: 5px;
	background-color: #f6d5f9;
	font-size: 20px;
	color: #ffffff;
	font-weight: 500;
	width: 800;
}

.btn-big::after {
	border: none;
}

.container-minipost {
	display: flex;
	flex-direction: column;
	align-items: left;
	justify-content: space-between;
	padding: 55rpx 60rpx 55rpx 50rpx;
	box-sizing: border-box;
	background: #ffffff;
	border-radius: 30px;
}
.container-detail {
	display: flex;
	flex-direction: column;
	align-items: left;
	justify-content: space-between;
	padding: 55rpx 60rpx 55rpx 50rpx;
	box-sizing: border-box;
	background: #ffffff;
	word-break: break-all;
}

.container-ad {
	display: flex;
	flex-direction: column;
	align-items: left;
	justify-content: space-between;
	padding: 55rpx 60rpx 55rpx 50rpx;
	box-sizing: border-box;
	background: #f0c0c3;
	word-break: break-all;
}

.weui-search-bar {
	position: relative;
	padding: 8px 10px;
	display: -webkit-box;
	display: -webkit-flex;
	display: flex;
	box-sizing: border-box;
	background-color: #f9f9f9;
	border-top: 0rpx;
	border-bottom: 0rpx;
}
.weui-icon-search {
	margin-right: 4px;
	font-size: inherit;
}
.weui-icon-search_in-box {
	position: absolute;
	left: 10px;
	top: 7px;
}
.weui-search-bar__text {
	display: inline-block;
	font-size: 16px;
}
.weui-search-bar__form {
	position: relative;
	-webkit-box-flex: 1;
	-webkit-flex: auto;
	flex: auto;
	border-radius: 5px;
	background: #ffffff;
	border: 1rpx solid #ffffff;
}
.weui-search-bar__box {
	position: relative;
	padding-left: 30px;
	padding-right: 30px;
	width: 100%;
	box-sizing: border-box;
	z-index: 1;
}
.weui-search-bar__input {
	height: 28px;
	line-height: 28px;
	font-size: 14px;
}
.weui-search-bar__label {
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	z-index: 2;
	border-radius: 3px;
	text-align: center;
	color: #9b9b9b;
	background: #ffffff;
	line-height: 28px;
}
.weui-search-bar__search-btn {
	margin-left: 10px;
	line-height: 28px;
	color: #f6d5f9;
	white-space: nowrap;
}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwUEZXUERYJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLGFBQWE7O0FBRWIsMkJBQTJCO0FBQzNCLHdCQUF3Qjs7QUFFeEI7RUFDRSxjQUFjO0VBQ2QsZ0JBQWdCO0VBQ2hCLHlCQUF5QjtBQUMzQjs7QUFFQTtFQUNFLGFBQWE7RUFDYixzQkFBc0I7RUFDdEIsaUJBQWlCO0VBQ2pCLDhCQUE4QjtFQUM5QixjQUFjO0VBQ2Qsc0JBQXNCO0VBQ3RCLG1CQUFtQjtBQUNyQjs7QUFFQTtFQUNFLG1CQUFtQjtFQUNuQixXQUFXO0VBQ1gsVUFBVTtFQUNWLFlBQVk7QUFDZDs7QUFFQTtFQUNFLG1CQUFtQjtFQUNuQixXQUFXO0VBQ1gsV0FBVztFQUNYLGFBQWE7QUFDZjs7QUFFQTtFQUNFLG1CQUFtQjtFQUNuQixXQUFXO0VBQ1gsV0FBVztFQUNYLGNBQWM7QUFDaEI7O0FBRUE7RUFDRSxtQkFBbUI7QUFDckI7O0FBRUE7RUFDRSx5QkFBeUI7RUFDekIsa0JBQWtCO0VBQ2xCLHVCQUF1QjtFQUN2QixlQUFlO0VBQ2YsYUFBYTtBQUNmOztBQUVBO0VBQ0UsWUFBWTtBQUNkOztBQUVBO0VBQ0UsWUFBWTtFQUNaLGtCQUFrQjtFQUNsQix5QkFBeUI7RUFDekIsZUFBZTtFQUNmLGFBQWE7RUFDYixnQkFBZ0I7RUFDaEIsVUFBVTtBQUNaOztBQUVBO0VBQ0UsWUFBWTtBQUNkOztBQUVBO0VBQ0UsYUFBYTtFQUNiLHNCQUFzQjtFQUN0QixpQkFBaUI7RUFDakIsOEJBQThCO0VBQzlCLGdDQUFnQztFQUNoQyxzQkFBc0I7RUFDdEIsbUJBQW1CO0VBQ25CLG1CQUFtQjtBQUNyQjtBQUNBO0VBQ0UsYUFBYTtFQUNiLHNCQUFzQjtFQUN0QixpQkFBaUI7RUFDakIsOEJBQThCO0VBQzlCLGdDQUFnQztFQUNoQyxzQkFBc0I7RUFDdEIsbUJBQW1CO0VBQ25CLG9CQUFvQjtBQUN0Qjs7QUFFQTtFQUNFLGFBQWE7RUFDYixzQkFBc0I7RUFDdEIsaUJBQWlCO0VBQ2pCLDhCQUE4QjtFQUM5QixnQ0FBZ0M7RUFDaEMsc0JBQXNCO0VBQ3RCLG1CQUFtQjtFQUNuQixvQkFBb0I7QUFDdEI7O0FBRUE7RUFDRSxrQkFBa0I7RUFDbEIsaUJBQWlCO0VBQ2pCLG9CQUFvQjtFQUNwQixxQkFBcUI7RUFDckIsYUFBYTtFQUNiLHNCQUFzQjtFQUN0Qix5QkFBeUI7RUFDekIsZ0JBQWdCO0VBQ2hCLG1CQUFtQjtBQUNyQjtBQUNBO0VBQ0UsaUJBQWlCO0VBQ2pCLGtCQUFrQjtBQUNwQjtBQUNBO0VBQ0Usa0JBQWtCO0VBQ2xCLFVBQVU7RUFDVixRQUFRO0FBQ1Y7QUFDQTtFQUNFLHFCQUFxQjtFQUNyQixlQUFlO0FBQ2pCO0FBQ0E7RUFDRSxrQkFBa0I7RUFDbEIsbUJBQW1CO0VBQ25CLGtCQUFrQjtVQUNWLFVBQVU7RUFDbEIsa0JBQWtCO0VBQ2xCLG1CQUFtQjtFQUNuQiwwQkFBMEI7QUFDNUI7QUFDQTtFQUNFLGtCQUFrQjtFQUNsQixrQkFBa0I7RUFDbEIsbUJBQW1CO0VBQ25CLFdBQVc7RUFDWCxzQkFBc0I7RUFDdEIsVUFBVTtBQUNaO0FBQ0E7RUFDRSxZQUFZO0VBQ1osaUJBQWlCO0VBQ2pCLGVBQWU7QUFDakI7QUFDQTtFQUNFLGtCQUFrQjtFQUNsQixNQUFNO0VBQ04sUUFBUTtFQUNSLFNBQVM7RUFDVCxPQUFPO0VBQ1AsVUFBVTtFQUNWLGtCQUFrQjtFQUNsQixrQkFBa0I7RUFDbEIsY0FBYztFQUNkLG1CQUFtQjtFQUNuQixpQkFBaUI7QUFDbkI7QUFDQTtFQUNFLGlCQUFpQjtFQUNqQixpQkFBaUI7RUFDakIsY0FBYztFQUNkLG1CQUFtQjtBQUNyQiIsImZpbGUiOiJ0by5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiphcHAud3hzcyoqL1xuXG5AaW1wb3J0ICdzdHlsZS93eGJvb3RzdHJhcCc7XG5AaW1wb3J0ICdzdHlsZS9pY29uZm9udCc7XG5cbnBhZ2UgeyAgXG4gIGRpc3BsYXk6IGJsb2NrOyAgXG4gIG1pbi1oZWlnaHQ6IDEwMCU7ICBcbiAgYmFja2dyb3VuZC1jb2xvcjogI2Y5ZjlmOTsgIFxufVxuXG4uY29udGFpbmVyIHtcbiAgZGlzcGxheTogZmxleDtcbiAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgYWxpZ24taXRlbXM6IGxlZnQ7XG4gIGp1c3RpZnktY29udGVudDogc3BhY2UtYmV0d2VlbjtcbiAgcGFkZGluZzogMTAwIDA7XG4gIGJveC1zaXppbmc6IGJvcmRlci1ib3g7XG4gIGJhY2tncm91bmQ6ICNmZmZmZmY7XG59IFxuXG4uZGl2TGluZXtcbiAgYmFja2dyb3VuZDogI0UwRTNEQTtcbiAgbWFyZ2luOmF1dG87XG4gIHdpZHRoOiA5NCU7XG4gIGhlaWdodDogMXJweDtcbn1cblxuLmRpdkxpbmUtYmlne1xuICBiYWNrZ3JvdW5kOiAjZjBmMGYwO1xuICBtYXJnaW46YXV0bztcbiAgd2lkdGg6IDEwMCU7XG4gIGhlaWdodDogMjBycHg7XG59XG5cbi5kaXZMaW5lLWJvdHRvbXtcbiAgYmFja2dyb3VuZDogI2YwZjBmMDtcbiAgbWFyZ2luOmF1dG87XG4gIHdpZHRoOiAxMDAlO1xuICBoZWlnaHQ6IDE0MHJweDtcbn1cblxuLmF2YXRhcntcbiAgYm9yZGVyLXJhZGl1czogMjVweDtcbn1cblxuLmJ0bntcbiAgYm9yZGVyOiAycHggc29saWQgI2Y2ZDVmOTsgXG4gIGJvcmRlci1yYWRpdXM6IDVweDsgIFxuICBiYWNrZ3JvdW5kLWNvbG9yOiB3aGl0ZTtcbiAgZm9udC1zaXplOiAxM3B4O1xuICBjb2xvcjojZjZkNWY5O1xufVxuXG4uYnRuOjphZnRlcntcbiAgYm9yZGVyOiBub25lOyBcbn1cblxuLmJ0bi1iaWd7XG4gIGJvcmRlcjogbm9uZTsgXG4gIGJvcmRlci1yYWRpdXM6IDVweDsgIFxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjZjZkNWY5O1xuICBmb250LXNpemU6IDIwcHg7XG4gIGNvbG9yOiNmZmZmZmY7XG4gIGZvbnQtd2VpZ2h0OiA1MDA7XG4gIHdpZHRoOiA4MDA7XG59XG5cbi5idG4tYmlnOjphZnRlcntcbiAgYm9yZGVyOiBub25lOyBcbn1cblxuLmNvbnRhaW5lci1taW5pcG9zdCB7XG4gIGRpc3BsYXk6IGZsZXg7XG4gIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XG4gIGFsaWduLWl0ZW1zOiBsZWZ0O1xuICBqdXN0aWZ5LWNvbnRlbnQ6IHNwYWNlLWJldHdlZW47XG4gIHBhZGRpbmc6IDU1cnB4IDYwcnB4IDU1cnB4IDUwcnB4O1xuICBib3gtc2l6aW5nOiBib3JkZXItYm94O1xuICBiYWNrZ3JvdW5kOiAjZmZmZmZmO1xuICBib3JkZXItcmFkaXVzOiAzMHB4O1xufSBcbi5jb250YWluZXItZGV0YWlsIHtcbiAgZGlzcGxheTogZmxleDtcbiAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgYWxpZ24taXRlbXM6IGxlZnQ7XG4gIGp1c3RpZnktY29udGVudDogc3BhY2UtYmV0d2VlbjtcbiAgcGFkZGluZzogNTVycHggNjBycHggNTVycHggNTBycHg7XG4gIGJveC1zaXppbmc6IGJvcmRlci1ib3g7XG4gIGJhY2tncm91bmQ6ICNmZmZmZmY7XG4gIHdvcmQtYnJlYWs6YnJlYWstYWxsO1xufSBcblxuLmNvbnRhaW5lci1hZCB7XG4gIGRpc3BsYXk6IGZsZXg7XG4gIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XG4gIGFsaWduLWl0ZW1zOiBsZWZ0O1xuICBqdXN0aWZ5LWNvbnRlbnQ6IHNwYWNlLWJldHdlZW47XG4gIHBhZGRpbmc6IDU1cnB4IDYwcnB4IDU1cnB4IDUwcnB4O1xuICBib3gtc2l6aW5nOiBib3JkZXItYm94O1xuICBiYWNrZ3JvdW5kOiAjZjBjMGMzO1xuICB3b3JkLWJyZWFrOmJyZWFrLWFsbDtcbn0gXG5cbi53ZXVpLXNlYXJjaC1iYXIge1xuICBwb3NpdGlvbjogcmVsYXRpdmU7XG4gIHBhZGRpbmc6IDhweCAxMHB4O1xuICBkaXNwbGF5OiAtd2Via2l0LWJveDtcbiAgZGlzcGxheTogLXdlYmtpdC1mbGV4O1xuICBkaXNwbGF5OiBmbGV4O1xuICBib3gtc2l6aW5nOiBib3JkZXItYm94O1xuICBiYWNrZ3JvdW5kLWNvbG9yOiAjZjlmOWY5O1xuICBib3JkZXItdG9wOiAwcnB4O1xuICBib3JkZXItYm90dG9tOiAwcnB4O1xufVxuLndldWktaWNvbi1zZWFyY2gge1xuICBtYXJnaW4tcmlnaHQ6IDRweDtcbiAgZm9udC1zaXplOiBpbmhlcml0O1xufVxuLndldWktaWNvbi1zZWFyY2hfaW4tYm94IHtcbiAgcG9zaXRpb246IGFic29sdXRlO1xuICBsZWZ0OiAxMHB4O1xuICB0b3A6IDdweDtcbn1cbi53ZXVpLXNlYXJjaC1iYXJfX3RleHQge1xuICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7XG4gIGZvbnQtc2l6ZTogMTZweDtcbn1cbi53ZXVpLXNlYXJjaC1iYXJfX2Zvcm0ge1xuICBwb3NpdGlvbjogcmVsYXRpdmU7XG4gIC13ZWJraXQtYm94LWZsZXg6IDE7XG4gIC13ZWJraXQtZmxleDogYXV0bztcbiAgICAgICAgICBmbGV4OiBhdXRvO1xuICBib3JkZXItcmFkaXVzOiA1cHg7XG4gIGJhY2tncm91bmQ6ICNmZmZmZmY7XG4gIGJvcmRlcjogMXJweCBzb2xpZCAjZmZmZmZmO1xufVxuLndldWktc2VhcmNoLWJhcl9fYm94IHtcbiAgcG9zaXRpb246IHJlbGF0aXZlO1xuICBwYWRkaW5nLWxlZnQ6IDMwcHg7XG4gIHBhZGRpbmctcmlnaHQ6IDMwcHg7XG4gIHdpZHRoOiAxMDAlO1xuICBib3gtc2l6aW5nOiBib3JkZXItYm94O1xuICB6LWluZGV4OiAxO1xufVxuLndldWktc2VhcmNoLWJhcl9faW5wdXQge1xuICBoZWlnaHQ6IDI4cHg7XG4gIGxpbmUtaGVpZ2h0OiAyOHB4O1xuICBmb250LXNpemU6IDE0cHg7XG59XG4ud2V1aS1zZWFyY2gtYmFyX19sYWJlbCB7XG4gIHBvc2l0aW9uOiBhYnNvbHV0ZTtcbiAgdG9wOiAwO1xuICByaWdodDogMDtcbiAgYm90dG9tOiAwO1xuICBsZWZ0OiAwO1xuICB6LWluZGV4OiAyO1xuICBib3JkZXItcmFkaXVzOiAzcHg7XG4gIHRleHQtYWxpZ246IGNlbnRlcjtcbiAgY29sb3I6ICM5QjlCOUI7XG4gIGJhY2tncm91bmQ6ICNGRkZGRkY7XG4gIGxpbmUtaGVpZ2h0OiAyOHB4O1xufVxuLndldWktc2VhcmNoLWJhcl9fc2VhcmNoLWJ0biB7XG4gIG1hcmdpbi1sZWZ0OiAxMHB4O1xuICBsaW5lLWhlaWdodDogMjhweDtcbiAgY29sb3I6ICNmNmQ1Zjk7XG4gIHdoaXRlLXNwYWNlOiBub3dyYXA7XG59Il19 */
</style>
