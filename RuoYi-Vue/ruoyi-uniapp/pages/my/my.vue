<template>
	<page-meta style="fontsize: 25">
		<navigation-bar
			:title="nbTitle"
			:loading="nbLoading"
			:front-color="nbFrontColor"
			:background-color="nbBackgroundColor"
			color-animation-duration="2000"
			color-animation-timing-func="easeIn"
		></navigation-bar>
	</page-meta>
	<view>
		<!--mine.wxml-->
		<block v-if="!hasUserInfo">
			<view style="width: 750rpx; background: #FFFFFF; min-height: 100px; height: 301rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
				<text class="iconfont icon-touxiang" style="position: relative; left: 66rpx; top: 88rpx; font-size: 65px"></text>
				<button
					type="primary"
					@tap="getUserProfile"
					style="width: 276rpx; height: 84rpx; display: block; box-sizing: border-box; left: 22rpx; top: -26rpx; position: relative"
				>
					点击登录
				</button>
			</view>
			<view
				style="background-color: #FFFFFF;display: flex; flex-direction: column; min-height: 150px; padding: 10px; margin-bottom: 10px; width: 750rpx; height: 216rpx; box-sizing: border-box; left: NaNrpx; top: NaNrpx"
			>
				<view class="divLine"></view>
				<navigator url="../about/about" class="weui-cell weui-cell_access" hover-class="weui-cell_active">
					<text class="iconfont icon-guanyu" style="position: relative; left: 44rpx; top: 25rpx; font-size: 25px"></text>
					<text style="position: relative; left: 74rpx; top: 19rpx; font-size: 25px">关于我们</text>
					<text class="iconfont icon-rightarrow" style="position: relative; left: 420rpx; top: 15rpx;font-size:20px"></text>
				</navigator>
				<view style="position: relative; left: 0rpx; top: 44rpx" class="divLine"></view>
			</view>
		</block>
		<block v-else>
			<view style="width: 750rpx; background: #FFFFFF; min-height: 100px; height: 301rpx; display: block; box-sizing: border-box; left: NaNrpx; top: NaNrpx">
				<image
					class="avatar"
					style="position: relative; left: 66rpx; top: 88rpx; width: 130rpx; height: 130rpx; display: inline-block; box-sizing: border-box"
					:src="userInfo.avatarUrl"
					mode="cover"
				></image>
				<text class="userinfo-nickname" style="position: relative; left: 120rpx; top: 36rpx;font-size:30px;">{{ userInfo.nickName }}</text>
			</view>
			<view
				style="display: flex; flex-direction: column; min-height: 150px; padding: 10px; margin-bottom: 10px; width: 750rpx; height: 368rpx; box-sizing: border-box; left: NaNrpx; top: NaNrpx"
			>
				<view class="divLine"></view>
				<view style="background-color: #FFFFFF; flex: 1;">
					<navigator url="myPost/myPost" class="weui-cell weui-cell_access" hover-class="weui-cell_active">
						<text class="iconfont icon-fabu" style="position: relative; left: 46rpx; top: 15rpx;font-size:25px"></text>
						<text style="position: relative; left: 75rpx; top: 15rpx;font-size:25px">我的发布</text>
						<text class="iconfont icon-rightarrow" style="position: relative; left: 420rpx; top: 15rpx;font-size:20px"></text>
					</navigator>
				</view>
				<view class="divLine"></view>
				<view style="background-color: #FFFFFF; flex: 1;">
					<navigator url="myHelp/myHelp" class="weui-cell weui-cell_access" hover-class="weui-cell_active">
						<text class="iconfont icon-dingdan" style="position: relative; left: 46rpx; top: 15rpx;font-size:25px"></text>
						<text style="position: relative; left: 75rpx; top: 15rpx;font-size:25px">我的帮助</text>
						<text class="iconfont icon-rightarrow" style="position: relative; left: 420rpx; top: 15rpx;font-size:20px"></text>
					</navigator>
				</view>
				<view class="divLine"></view>
				<view style="background-color: #FFFFFF; flex: 1;">
					<navigator url="../about/about" class="weui-cell weui-cell_access" hover-class="weui-cell_active">
						<text class="iconfont icon-guanyu" style="position: relative; left: 46rpx; top: 15rpx;font-size:25px"></text>
						<text style="position: relative; left: 75rpx; top: 15rpx;font-size:25px">关于我们</text>
						<text class="iconfont icon-rightarrow" style="position: relative; left: 420rpx; top: 15rpx;font-size:20px"></text>
					</navigator>
				</view>
				<view class="divLine"></view>
			</view>
		</block>
	</view>
</template>

<script>
const app = getApp();

export default {
	data() {
		return {
			nbFrontColor: '#000000',
			nbBackgroundColor: '#fae4fa',
			userInfo: {
				avatarUrl: '',
				nickName: ''
			},
			hasUserInfo: false,
			nbLoading: '',
			nbTitle: ''
		};
	},

	components: {},
	props: {},

	onLoad() {
		this.setData({
			nbTitle: '我的',
			nbLoading: false
		}),
			this.canIUseProfile();
	},

	methods: {
		canIUseProfile: function() {
			var that = this;
			app.globalData.checkSession_3rd();
			uni.request({
				url: app.globalData.domain + '/wx/account/checkUserProfile',
				data: {
					session_3rd: app.globalData.session_3rd
				},
				success: request_res => {
					if (request_res.data == false) {
						that.setData({
							hasUserInfo: false
						});
					} else {
						that.setData({
							hasUserInfo: true
						});
						uni.request({
							url: app.globalData.domain + '/wx/account/getUserProfile',
							data: {
								session_3rd: app.globalData.session_3rd
							},
							success: request_res => {
								console.log(request_res.data);
								that.setData({
									userInfo: request_res.data
								});
							}
						});
					}
				}
			});
		},
		getUserProfile: function() {
			// 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认
			// 开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
			uni.getUserProfile({
				desc: '用于完善会员资料',
				// 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
				success: profile_res => {
					console.log(profile_res.userInfo);
					this.setData({
						userInfo: profile_res.userInfo,
						hasUserInfo: true
					});
					this.setUserProfile(profile_res.userInfo);
				}
			});
		},
		setUserProfile: function(userInfo) {
			uni.request({
				url: app.globalData.domain + '/wx/account/updateUserProfile',
				method: 'POST',
				data: {
					session_3rd: app.globalData.session_3rd,
					avatarUrl: userInfo.avatarUrl,
					city: userInfo.city,
					country: userInfo.country,
					gender: userInfo.gender,
					language: userInfo.language,
					nickName: userInfo.nickName,
					province: userInfo.province
				},
				success: function(res) {
					console.log('保存成功');
				}
			});
		}
	}
};
</script>
<style>
/* pages/my/my.wxss */

.avatar {
	border-radius: 25px;
}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwd3BEekVHJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLHFCQUFxQjs7QUFFckI7RUFDRSxtQkFBbUI7QUFDckIiLCJmaWxlIjoidG8uY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLyogcGFnZXMvbXkvbXkud3hzcyAqL1xyXG5cclxuLmF2YXRhcntcclxuICBib3JkZXItcmFkaXVzOiAyNXB4O1xyXG59Il19 */
</style>
