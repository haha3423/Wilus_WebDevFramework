package com.wilus.demo.service.rental

import com.wilus.demo.dto.rental.RentalInfoDto
import com.wilus.demo.dto.rental.RentalSearchDto
import com.wilus.demo.entity.rental.f56R001.F56r001Repository
import mu.KotlinLogging
import org.springframework.stereotype.Service


@Service
class RentalService(
    val rentalRepository: F56r001Repository
) {

    private val log = KotlinLogging.logger {  }

    fun findRentalInfoList(rentalSearchDto: RentalSearchDto): List<RentalInfoDto> {
        log.info { "---- rentalSearchDto : $rentalSearchDto" }
        return rentalRepository.findByNameAndSerialAndDisp(
            rentalSearchDto.empName, rentalSearchDto.serialNo, rentalSearchDto.dispatch
        ).map { it.toRentalInfoDto() }
    }

}