package com.wilus.demo.dto.rental

import java.time.LocalDate

data class RentalInfoDto(
    val gearNo: Long,
    val dispatch: String,
    val empNo: Long,
    val empName: String,
    val gearType: String,
    val gearTypeName: String,
    val gearName: String,
    var rentalDate: String? = null,
    var returnDate: String? = null,
    val serialNo: String,
    var memo: String? = null,
)