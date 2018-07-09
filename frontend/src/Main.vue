<template>
  <el-container>
		<div class="cont-header">
			<el-header>
				<el-button icon="el-icon-setting" class="create-btn" @click="showSettingDialog = true"></el-button>
			</el-header>
		</div>
		<el-main>
			<div class="cont-body">
				<div class="body-header">
					<el-button type="success" @click="showCreateDialog = true" class="create-btn">
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
				<el-button type="warning" @click="showChargeDialog = true">예치금 충전</el-button>
			</div>
		</el-footer>
		<el-dialog :title="label.createTitle" :visible.sync="showCreateDialog" width="30%">
			<create-delivery
				@close="showCreateDialog = false"
				@onClickCreate="onClickCreate"
			/>
		</el-dialog>
		<el-dialog :title="label.chargeTitle" :visible.sync="showChargeDialog" width="30%">
			<charge-deposit
				@close="showChargeDialog = false"
				@onClickCharge="onClickCharge"
			/>
		</el-dialog>
		<el-dialog :title="label.settingTitle" :visible.sync="showSettingDialog" width="30%">
			<setting-info
				@close="showSettingDialog = false"
				@onClickSetting="onClickSetting"
			/>
		</el-dialog>
  </el-container>
</template>

<script>
import TrackingDelivery from './trackingDelivery/TrackingDelivery'
import ChargeDeposit from './trackingDelivery/ChargeDeposit'
import CreateDelivery from './trackingDelivery/CreateDelivery'
import SettingInfo from './trackingDelivery/SettingInfo'
import Constants from './common/constants/Constants'

export default {
	name: 'Main',
	components: { TrackingDelivery, ChargeDeposit, CreateDelivery, SettingInfo },
	data() {
		return {
			activeName: 'first',
			showChargeDialog: false,
			showCreateDialog: false,
			showSettingDialog: false,
			label: {
				chargeTitle: Constants.LABEL.CHARGE.title,
				createTitle: Constants.LABEL.CREATE.title,
				settingTitle: Constants.LABEL.SETTING.title
			}
		}
	},
	methods: {
		handleClick(tab, event) {
			console.log(tab, event)
		},
		onClickCharge(result) {
			if (result !== 'cancel') {
				// call charge deposit API
			}
			this.showChargeDialog = false
		},
		onClickCreate(result) {
			if (result !== 'cancel') {
				// call create delivery API
			}
			this.showCreateDialog = false
		},
		onClickSetting(result) {
			if (result !== 'cancel') {
				// call create delivery API
			}
			this.showSettingDialog = false
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