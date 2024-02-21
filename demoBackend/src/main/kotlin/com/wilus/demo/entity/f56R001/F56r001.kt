package com.wilus.demo.entity.f56R001

import com.wilus.demo.dto.rental.RentalInfoDto
import com.wilus.demo.entity.f55C004.F55c004
import com.wilus.demo.entity.f56e001.F56e001
import com.wilus.demo.util.CommUtil
import jakarta.persistence.*
import org.hibernate.annotations.Nationalized

@Entity
@Table(name = "F56R001")
class F56r001(
    @EmbeddedId
    var id: F56r001Id? = null,

    @OneToOne
    @JoinColumn(name = "R1UKID", referencedColumnName = "E1UKID", insertable = false, updatable = false)
    var gear: F56e001? = null, // 장비관리

    @Column(name = "R1CDTE")
    var r1cdte: Int? = null,

    @Column(name = "R1AN81")
    var r1an81: Long? = null,

    @OneToOne
    @JoinColumn(name = "R1AN81", referencedColumnName = "C4AN81", insertable = false, updatable = false)
    var emp: F55c004? = null, // 사용자

    @Nationalized
    @Column(name = "R1D200", length = 200)
    var r1d200: String? = null,

    @Nationalized
    @Column(name = "R1EV01", length = 1)
    var r1ev01: String? = null,

    @Nationalized
    @Column(name = "R1URCD", length = 2)
    var r1urcd: String? = null,

    @Column(name = "R1URDT")
    var r1urdt: Int? = null,

    @Column(name = "R1URAT")
    var r1urat: Long? = null,

    @Column(name = "R1URAB")
    var r1urab: Long? = null,

    @Nationalized
    @Column(name = "R1URRF", length = 15)
    var r1urrf: String? = null,

    @Nationalized
    @Column(name = "R1USER", length = 10)
    var r1user: String? = null,

    @Nationalized
    @Column(name = "R1PID", length = 10)
    var r1pid: String? = null,

    @Nationalized
    @Column(name = "R1JOBN", length = 10)
    var r1jobn: String? = null,

    @Column(name = "R1UPMJ")
    var r1upmj: Int? = null,

    @Column(name = "R1UPMT")
    var r1upmt: Long? = null,
) {

    fun toRentalInfoDto():RentalInfoDto {
        return RentalInfoDto(
            gearNo = id?.r1ukid!!,
            dispatch = (r1ev01?: "N").trimIndent(),
            empNo = emp?.id?: 0,
            empName = (emp?.c4dan8?: "").trimIndent(),
            gearType = (gear?.e1rtecd?: "").trimIndent(),
            gearTypeName = (gear?.e1rtocd?: "").trimIndent(),
            gearName = (gear?.e1dsc2?: "").trimIndent(),
            rentalDate = id?.r1csdt?.let { CommUtil().toStringFromJulian(it).trimIndent() },
            returnDate = r1cdte?.let { CommUtil().toStringFromJulian(it).trimIndent() },
            serialNo = (gear?.e1seri?: "").trimIndent(),
            memo = (r1d200?: "").trimIndent()
        )
    }

}