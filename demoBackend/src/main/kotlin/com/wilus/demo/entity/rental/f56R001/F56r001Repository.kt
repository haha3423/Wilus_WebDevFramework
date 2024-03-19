package com.wilus.demo.entity.rental.f56R001;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface F56r001Repository : JpaRepository<F56r001, F56r001Id> {

    @Query(
        """select f from F56r001 f
            where 1=1 
            and (:name is null or trim(f.emp.c4dan8) like %:name% ) 
            and (:serial is null or trim(f.gear.e1seri) like %:serial% )
            and (:dispatch is null or trim(f.r1ev01) like %:dispatch% )
            order by f.id.r1ukid DESC, f.id.r1csdt DESC"""
    )
    fun findByNameAndSerialAndDisp(
        name: String?, serial: String?, dispatch: String?
    ): List<F56r001>

}