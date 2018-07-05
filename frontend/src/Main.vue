<template>
  <el-container>
		<div class="cont-header">
			<el-header>
				<el-button icon="el-icon-setting" class="create-btn"></el-button>
			</el-header>
		</div>
		<el-main>
			<div class="cont-body">
				<div class="body-header">
					<el-button type="success" @click="showDialog = true" class="create-btn">
						배송 등록
					</el-button>
				</div>
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
		</el-main>
		<el-footer>
			<div class="cont-footer">
				<el-card class="box-card">
					<div class="card-body">
						남은 예치금
						3000원
					</div>
				</el-card>
				<el-button type="warning">예치금 충전</el-button>
			</div>
		</el-footer>
		<el-dialog :title="label.title" :visible.sync="showDialog" width="30%">
			<create-delivery
				:showDialog="showDialog"
				@close="showDialog = false"
				@createDelivery="createDelivery"
			/>
		</el-dialog>
  </el-container>
</template>

<script>
import TrackingDelivery from './trackingDelivery/TrackingDelivery'
import CreateDelivery from './trackingDelivery/CreateDelivery'
import Constants from './common/constants/Constants'

export default {
	name: 'TabIcons',
	components: { TrackingDelivery, CreateDelivery },
	data() {
		return {
			activeName: 'first',
			showDialog: false,
			label: {
				title: Constants.LABEL.CREATE.title
			}
		}
	},
	methods: {
		handleClick(tab, event) {
			console.log(tab, event)
		},
		createDelivery(result) {
			console.log(result)
			if (result !== 'cancel') {
				// call create delivery API
			}
			this.showDialog = false
		}
	}
}
</script>

<style lang="scss" scoped>
  .cont-header {
		padding: 20px 20px 0 20px;
	}
	.cont-body {
		padding: 0 20px 20px 20px;
	}
	.cont-footer {
		padding-left: 20px;
		float: right;
	}
	.body-header {
		width: 100%;
    display: inline-block;
	}
	.box-card {
		display: inline-block;
		vertical-align: middle;
    width: 120px;
		height: 41px;
		margin-top: -5px;
  }
	.el-card__body{
		padding: none !important;
	}
	.card-body {
		margin-top: -18px;
		font-size: 12px;
	}
	.create-btn {
		float: right;
	}
</style>