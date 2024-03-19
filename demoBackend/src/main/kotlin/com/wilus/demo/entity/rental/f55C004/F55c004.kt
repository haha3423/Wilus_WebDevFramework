package com.wilus.demo.entity.rental.f55C004

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Nationalized

@Entity
@Table(name = "F55C004")
open class F55c004 {

    @Id
    @Column(name = "C4AN81", nullable = false)
    open var id: Long? = null

    @Nationalized
    @Column(name = "C4DAN8", length = 30)
    open var c4dan8: String? = null

    @Nationalized
    @Column(name = "C4CACTN", length = 2)
    open var c4cactn: String? = null

    @Nationalized
    @Column(name = "C4PH1", length = 20)
    open var c4ph1: String? = null

    @Nationalized
    @Column(name = "C4PH2", length = 20)
    open var c4ph2: String? = null

    @Nationalized
    @Column(name = "C4EMAIL", length = 75)
    open var c4email: String? = null

    @Nationalized
    @Column(name = "C4DEPT", length = 12)
    open var c4dept: String? = null

    @Nationalized
    @Column(name = "C4CDAA", length = 2)
    open var c4cdaa: String? = null

    @Column(name = "C4RUPD")
    open var c4rupd: Int? = null

    @Nationalized
    @Column(name = "C4OMWPJS1", length = 30)
    open var c4omwpjs1: String? = null

    @Column(name = "C4SERD")
    open var c4serd: Int? = null

    @Nationalized
    @Column(name = "C4JOB", length = 8)
    open var c4job: String? = null

    @Nationalized
    @Column(name = "C4EINDC", length = 1)
    open var c4eindc: String? = null

    @Nationalized
    @Column(name = "C4URCD", length = 2)
    open var c4urcd: String? = null

    @Column(name = "C4URDT")
    open var c4urdt: Int? = null

    @Column(name = "C4URAT")
    open var c4urat: Long? = null

    @Column(name = "C4URAB")
    open var c4urab: Long? = null

    @Nationalized
    @Column(name = "C4URRF", length = 15)
    open var c4urrf: String? = null

    @Nationalized
    @Column(name = "C4USER", length = 10)
    open var c4user: String? = null

    @Nationalized
    @Column(name = "C4PID", length = 10)
    open var c4pid: String? = null

    @Nationalized
    @Column(name = "C4JOBN", length = 10)
    open var c4jobn: String? = null

    @Column(name = "C4UPMJ")
    open var c4upmj: Int? = null

    @Column(name = "C4UPMT")
    open var c4upmt: Long? = null
}