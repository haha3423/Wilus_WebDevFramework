package com.wilus.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoBackendApplication

fun main(args: Array<String>) {
    runApplication<DemoBackendApplication>(*args)
}
