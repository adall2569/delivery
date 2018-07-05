<template>
	<div>
		<el-form :model="form" :label-width="formLabelWidth">
			<el-form-item :label="label.telephone">
				<el-input v-model="form.telephone"></el-input>
			</el-form-item>
			<el-form-item label="Activity time">
				<el-col :span="16">
					<el-date-picker type="date" :placeholder="label.dateMsg" v-model="form.lastOrderDate" style="width: 100%;"/>
				</el-col>
			</el-form-item>
			<el-form-item :label="label.address">
				<el-input v-model="form.address"></el-input>
			</el-form-item>
			<el-form-item :label="label.price">
				<el-input v-model="form.price"></el-input>
			</el-form-item>
			<el-form-item :label="label.pickUpTime">
				<el-input-number v-model="form.pickUpTime" :step="10"></el-input-number>
			</el-form-item>
			<el-form-item :label="label.paymentMethod">
				<el-radio v-model="form.paymentMethod" label="1">{{label.byCard}}</el-radio>
  			<el-radio v-model="form.paymentMethod" label="2">{{label.byChash}}</el-radio>
			</el-form-item>
			<el-form-item :label="label.deliveryFee">
				<el-input v-model="form.deliveryFee"></el-input>
			</el-form-item>
			<el-form-item class="dialog-footer">
				<el-button @click="createDelivery('cancel')">{{label.cancel}}</el-button>
				<el-button type="primary" @click="createDelivery">{{label.confirm}}</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
import Constants from '../common/constants/Constants'

export default {
	name: 'CreateDelivery',
	props: ['showDialog'],
	data() {
		return {
			form: {
				telephone: '',
				lastOrderDate: '',
				address: '',
				price: '',
				pickUpTime: '',
				paymentMethod: '',
				deliveryFee: ''
			},
			label: {
				telephone: Constants.LABEL.CREATE.telephone,
				lastOrderDate: Constants.LABEL.CREATE.lastOrderDate,
				dateMsg: Constants.LABEL.CREATE.dateMsg,
				address: Constants.LABEL.CREATE.address,
				price: Constants.LABEL.CREATE.price,
				pickUpTime: Constants.LABEL.CREATE.pickUpTime,
				paymentMethod: Constants.LABEL.CREATE.paymentMethod,
				deliveryFee: Constants.LABEL.CREATE.deliveryFee,
				byCard : Constants.LABEL.CREATE.byCard,
				byChash : Constants.LABEL.CREATE.byChash,
				cancel : Constants.LABEL.COMMON.cancel,
				confirm : Constants.LABEL.COMMON.confirm
			},
			formLabelWidth: '120px'
		}
	},
	methods: {
		handleCurrentChange(val) {
			this.currentRow = val
			// TODO: go to detail page
		},
		filterTag(value, row) {
			return row.tag === value
		},
		createDelivery(msg) {
			if (msg === 'cancel') {
				this.$emit('createDelivery', msg)
			} else {
				this.$emit('createDelivery', this.form)
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