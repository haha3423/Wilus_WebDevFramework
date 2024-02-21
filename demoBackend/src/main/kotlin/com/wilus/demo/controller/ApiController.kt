package com.wilus.demo.controller

import com.wilus.demo.dto.rental.RentalInfoDto
import com.wilus.demo.dto.rental.RentalSearchDto
import com.wilus.demo.service.rental.RentalService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController (
    val rentalService: RentalService
)
{

    @PostMapping("/find/rental")
    fun findRentalDetailList(@RequestBody rentalSearch: RentalSearchDto) :  List<RentalInfoDto> {
        return rentalService.findRentalInfoList(rentalSearch)
    }

}