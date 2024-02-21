package com.wilus.demo.entity.f56a001

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.annotations.Nationalized

@Entity
@Table(name = "F56A001")
open class F56a001 {
    @EmbeddedId
    open var id: F56a001Id? = null

    @Column(name = "A1CDTE")
    open var a1cdte: Int? = null

    @Column(name = "A1AN8")
    open var a1an8: Long? = null

    @Column(name = "A1AMTW")
    open var a1amtw: Long? = null

    @Nationalized
    @Column(name = "A1CNMR", length = 24)
    open var a1cnmr: String? = null

    @Nationalized
    @Column(name = "A1DL011", length = 100)
    open var a1dl011: String? = null

    @Nationalized
    @Column(name = "A1D200", length = 200)
    open var a1d200: String? = null

    @Nationalized
    @Column(name = "A1URCD", length = 2)
    open var a1urcd: String? = null

    @Column(name = "A1URDT")
    open var a1urdt: Int? = null

    @Column(name = "A1URAT")
    open var a1urat: Long? = null

    @Column(name = "A1URAB")
    open var a1urab: Long? = null

    @Nationalized
    @Column(name = "A1URRF", length = 15)
    open var a1urrf: String? = null

    @Nationalized
    @Column(name = "A1USER", length = 10)
    open var a1user: String? = null

    @Nationalized
    @Column(name = "A1PID", length = 10)
    open var a1pid: String? = null

    @Nationalized
    @Column(name = "A1JOBN", length = 10)
    open var a1jobn: String? = null

    @Column(name = "A1UPMJ")
    open var a1upmj: Int? = null

    @Column(name = "A1UPMT")
    open var a1upmt: Long? = null
}