package com.hopspot.beermanagr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BeerManagrApplication

fun main(args: Array<String>) {
	runApplication<BeerManagrApplication>(*args)
}