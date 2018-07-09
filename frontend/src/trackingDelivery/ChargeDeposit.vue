<template>
	<div>
		<el-form :model="form" :label-width="formLabelWidth">
			<el-form-item :label="label.current">
				<el-input v-model="form.current"/>
			</el-form-item>
			<el-form-item :label="label.additional">
				<el-input v-model="form.additional"/>
			</el-form-item>
			<el-form-item :label="label.after">
				<el-input v-model="form.after"/>
			</el-form-item>
			<el-form-item class="dialog-footer">
				<el-button @click="onClickCharge('cancel')">{{label.cancel}}</el-button>
				<el-button type="primary" @click="onClickCharge">{{label.charging}}</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
import Constants from '../common/constants/Constants'

export default {
	name: 'ChargeDeposit',
	props: [],
	data() {
		return {
			form: {
				additional: '',
				current: '',
				after: ''
			},
			label: {
				additional: Constants.LABEL.CHARGE.additional,
				after: Constants.LABEL.CHARGE.after,
				charging: Constants.LABEL.CHARGE.charging,
				current: Constants.LABEL.CHARGE.current,
				cancel : Constants.LABEL.COMMON.cancel
			},
			formLabelWidth: '120px'
		}
	},
	methods: {
		onClickCharge(msg) {
			if (msg === 'cancel') {
				this.$emit('onClickCharge', msg)
			} else {
				this.$emit('onClickCharge', this.form)
			}
		}
	}
}
</script>

<style lang="scss" scoped>
.el-input {
	width: 67%;
}
.dialog-footer {
	margin-left: 35px;
}
</style>