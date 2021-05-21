<template>
	<!--logs.wxml-->
	<view class="container log-list">
		<block v-for="(log, index) in logs" :key="index">
			<text class="log-item">{{ index + 1 }}. {{ log }}</text>
		</block>
	</view>
</template>

<script>
// logs.js
const util = require('../../utils/util.js');

export default {
	data() {
		return {
			logs: []
		};
	},

	components: {},
	props: {},

	onLoad() {
		this.setData({
			logs: (uni.getStorageSync('logs') || []).map(log => {
				return util.formatTime(new Date(log));
			})
		});
	},

	methods: {}
};
</script>
<style>
.log-list {
	display: flex;
	flex-direction: column;
	padding: 40rpx;
}
.log-item {
	margin: 10rpx;
}

/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwb1pacVdFJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsYUFBYTtFQUNiLHNCQUFzQjtFQUN0QixjQUFjO0FBQ2hCO0FBQ0E7RUFDRSxhQUFhO0FBQ2YiLCJmaWxlIjoidG8uY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmxvZy1saXN0IHtcbiAgZGlzcGxheTogZmxleDtcbiAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgcGFkZGluZzogNDBycHg7XG59XG4ubG9nLWl0ZW0ge1xuICBtYXJnaW46IDEwcnB4O1xufVxuIl19 */
</style>
