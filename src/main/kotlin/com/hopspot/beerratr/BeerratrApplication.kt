package com.hopspot.beerratr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BeerratrApplication

fun main(args: Array<String>) {
	runApplication<BeerratrApplication>(*args)
}
