package com.wilus.demo.entity.f56e001

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Nationalized

@Entity
@Table(name = "F56E001")
open class F56e001 {
    @Id
    @Column(name = "E1UKID", nullable = false)
    open var id: Long? = null

    @Column(name = "E1PRUKID")
    open var e1prukid: Long? = null

    @Nationalized
    @Column(name = "E1SERI", length = 25)
    open var e1seri: String? = null

    @Nationalized
    @Column(name = "E1DSC2", length = 30)
    open var e1dsc2: String? = null

    @Nationalized
    @Column(name = "E1RTECD", length = 2)
    open var e1rtecd: String? = null

    @Nationalized
    @Column(name = "E1RTOCD", length = 2)
    open var e1rtocd: String? = null

    @Nationalized
    @Column(name = "E1D200", length = 200)
    open var e1d200: String? = null

    @Nationalized
    @Column(name = "E1URCD", length = 2)
    open var e1urcd: String? = null

    @Column(name = "E1URDT")
    open var e1urdt: Int? = null

    @Column(name = "E1URAT")
    open var e1urat: Long? = null

    @Column(name = "E1URAB")
    open var e1urab: Long? = null

    @Nationalized
    @Column(name = "E1URRF", length = 15)
    open var e1urrf: String? = null

    @Nationalized
    @Column(name = "E1USER", length = 10)
    open var e1user: String? = null

    @Nationalized
    @Column(name = "E1PID", length = 10)
    open var e1pid: String? = null

    @Nationalized
    @Column(name = "E1JOBN", length = 10)
    open var e1jobn: String? = null

    @Column(name = "E1UPMJ")
    open var e1upmj: Int? = null

    @Column(name = "E1UPMT")
    open var e1upmt: Long? = null
}