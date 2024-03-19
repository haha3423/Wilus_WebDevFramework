package com.wilus.demo.entity.rental.f56R001

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class F56r001Id : Serializable {
    @Column(name = "R1UKID", nullable = false)
    open var r1ukid: Long? = null

    @Column(name = "R1CSDT", nullable = false)
    open var r1csdt: Int? = null

    override fun hashCode(): Int = Objects.hash(r1ukid, r1csdt)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as F56r001Id

        return r1ukid == other.r1ukid &&
                r1csdt == other.r1csdt
    }

    companion object {
        private const val serialVersionUID = -2824744074479450336L
    }
}