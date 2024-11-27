package com.cutecensus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CutecensusApplication

fun main(args: Array<String>) {
	runApplication<CutecensusApplication>(*args)
}
