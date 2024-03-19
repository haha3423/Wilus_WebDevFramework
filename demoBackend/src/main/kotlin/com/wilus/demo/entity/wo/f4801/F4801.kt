package com.wilus.demo.entity.wo.f4801

import com.wilus.demo.dto.wo.WorkOrderDto
import org.hibernate.annotations.Nationalized
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "F4801")
class F4801 (

    @Id
    @Column(name = "WADOCO")
    var doco: Long? = null,

    @Nationalized
    @Column(name = "WADCTO", length = 2)
    var dcto: String? = null,

    @Nationalized
    @Column(name = "WALITM")
    var litm: String? = null,

    @Nationalized
    @Column(name = "WAUOM", length = 2)
    var uom: String? = null,

    @Column(name = "WATRDJ", length = 6)
    var trdj: Number? = null,

    @Nationalized
    @Column(name = "WAMMCU", length = 12)
    var mmcu: String? = null,

    @Column(name = "WAUORG")
    var uorg: Number? = null,

    @Column(name = "WAAN8")
    var an8: Number? = null,
    // srst, lnid

){

    fun toWorkOrderDto(): WorkOrderDto {
        return WorkOrderDto(
            orderNo = doco,
            type = dcto,
            itemNo = litm,
            uom = uom,
            branch = mmcu,
            orderDate = trdj,
            orderQty = uorg,
            customer = an8,

            status = null,
            lineId = null
        )
    }

}
