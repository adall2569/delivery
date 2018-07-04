<template>
  <div>
    <el-table
			ref="singleTable"
			:data="tableData"
			highlight-current-row
			@current-change="handleCurrentChange"
			:default-sort = "{prop: 'startTime', order: 'descending'}"
			style="width: 100%"
		>
			<el-table-column
				type="index"
				width="50"
			/>
			<el-table-column
				property="startTime"
				label="시작 시간"
				width="200"
				sortable
			/>
			<el-table-column
				property="pickUpTime"
				label="픽업 시간"
				width="200"
			/>
			<el-table-column
				property="destination"
				label="배달 장소"
				width="200"
			/>
			<el-table-column
				property="price"
				label="결재 가격"
				width="200"
			/>
			<el-table-column
				property="method"
				label="결재 방법"
				width="200"
			/>
			<el-table-column
				property="deliveryMan"
				label="기사 정보"
				width="200"
			/>
			<el-table-column
				property="status"
				label="배송 상태"
				sortable
				:filters="statusFilter"
      	:filter-method="filterTag"
			/>
  	</el-table>
  </div>
</template>

<script>
export default {
	name: 'TrackingDelivery',
	data() {
		return {
			tableData: [{
				startTime: '2016-05-03',
				pickUpTime: '2016-05-03',
				destination: '예미지 빌딩',
				method: '현금',
				price: '30000',
				deliveryMan: '김시현',
				status: '주문 접수'
			}, {
				startTime: '2016-05-02',
				pickUpTime: '2016-05-03',
				destination: '수내역',
				method: '카드',
				price: '30000',
				deliveryMan: '김시현',
				status: '배달 출발'
			}, {
				startTime: '2016-05-04',
				pickUpTime: '2016-05-03',
				destination: '서현역',
				method: '카드',
				price: '35000',
				deliveryMan: '김시현',
				status: '배달 완료'
			}, {
				startTime: '2016-05-01',
				pickUpTime: '2016-05-03',
				destination: '로얄 팰리스 하우스빌',
				method: '카드',
				price: '50000',
				deliveryMan: '김시현',
				status: '주문 접수'
			}],
			statusFilter: [{
				text: '배달 완료',
				value: '배달 완료'
			}, {
				text: '배달 출발',
				value: '배달 출발'
			}, {
				text: '주문 접수',
				value: '주문 접수'
			}],
			currentRow: null
		}
	},
	methods: {
		handleCurrentChange(val) {
			this.currentRow = val
			// TODO: go to detail page
		},
		filterTag(value, row) {
			return row.tag === value
		}
	}
}
</script>

<style lang="scss" scoped>
</style>