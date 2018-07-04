<template>
  <div class="cont-area">
		<el-tabs v-model="activeName" @tab-click="handleClick">
			<el-tab-pane label="배송 조회" name="first">
				<tracking-delivery></tracking-delivery>
			</el-tab-pane>
			<el-tab-pane label="정산 조회" name="second">
				정산 조회 페이지
			</el-tab-pane>
			<el-tab-pane label="예치금 내역 조회" name="third">
				예치금 내역 조회 페이지
			</el-tab-pane>
  	</el-tabs>
  </div>
</template>

<script>
import TrackingDelivery from './trackingDelivery/TrackingDelivery'

export default {
	name: 'TabIcons',
	components: { TrackingDelivery },
	data() {
		return {
			activeName: 'first'
		}
	},
	methods: {
		handleClick(tab, event) {
			console.log(tab, event)
		}
	}
}
</script>

<style lang="scss" scoped>
  .cont-area {
		padding: 20px;
	}
</style>