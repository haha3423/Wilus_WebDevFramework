package com.wilus.demo.dto.wo

data class WorkOrderDto(
    var orderNo: Long?,
    var type: String?,
    var itemNo: String?,
    var uom: String?,
    var branch: String?,
    var orderDate: Number?,
    var orderQty: Number?,
    var status: String?,
    var lineId: Number?,
    var customer: Number?,
)