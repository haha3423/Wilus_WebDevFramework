package com.wilus.demo.entity.f56a001

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class F56a001Id : Serializable {
    @Column(name = "A1UKID", nullable = false)
    open var a1ukid: Long? = null

    @Column(name = "A1CSDT", nullable = false)
    open var a1csdt: Int? = null

    override fun hashCode(): Int = Objects.hash(a1ukid, a1csdt)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as F56a001Id

        return a1ukid == other.a1ukid &&
                a1csdt == other.a1csdt
    }

    companion object {
        private const val serialVersionUID = -8647559943085844763L
    }
}