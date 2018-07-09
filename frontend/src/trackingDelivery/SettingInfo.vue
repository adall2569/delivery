<template>
	<div>
		<el-form :model="form" :label-width="formLabelWidth">
			<el-form-item :label="label.companyName">
				<el-input v-model="form.companyName"/>
			</el-form-item>
			<el-form-item :label="label.telephone">
				<el-input v-model="form.telephone"/>
			</el-form-item>
			<el-form-item :label="label.address">
				<el-input v-model="form.address"/>
			</el-form-item>
			<el-form-item :label="label.resigDate">
				<el-input v-model="form.resigDate" :disabled="true"/>
			</el-form-item>
			<el-form-item class="dialog-footer">
				<el-button @click="onClickSetting('cancel')">{{label.cancel}}</el-button>
				<el-button type="primary" @click="onClickSetting">{{label.confirm}}</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
import Constants from '../common/constants/Constants'

export default {
	name: 'SettingInfo',
	props: [],
	data() {
		return {
			form: {
				companyName: '',
				telephone: '',
				address: '',
				resigDate: ''
			},
			label: {
				companyName: Constants.LABEL.SETTING.companyName,
				telephone: Constants.LABEL.SETTING.telephone,
				address: Constants.LABEL.SETTING.address,
				resigDate: Constants.LABEL.SETTING.resigDate,
				cancel : Constants.LABEL.COMMON.cancel,
				confirm : Constants.LABEL.COMMON.confirm
			},
			formLabelWidth: '120px'
		}
	},
	methods: {
		onClickSetting(msg) {
			if (msg === 'cancel') {
				this.$emit('onClickSetting', msg)
			} else {
				this.$emit('onClickSetting', this.form)
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