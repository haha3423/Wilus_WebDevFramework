package com.wilus.demo.entity.wo.f4801

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface F4801Repository : JpaRepository<F4801, Long>{

    @Query(
        """
            select t from F4801 t
            where 1=1 
            and (:doco is null or t.doco = :doco)
            and (:mmcu is null or t.mmcu like %:mmcu%)
        """
    )
    fun findByDocoAndMmcu(
        doco: Long?,
        mmcu: String?
    )

}