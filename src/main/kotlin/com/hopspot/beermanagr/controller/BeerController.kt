package com.hopspot.beermanagr.controller

import com.hopspot.beermanagr.model.Beer
import com.hopspot.beermanagr.repository.BeerRepository
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class BeerController(private val beerRepository: BeerRepository) {

    @GetMapping("/beers")
    fun getAllBeers(): List<Beer> = beerRepository.findAll()

    @PostMapping("/beers")
    fun createNewBeer(@Valid @RequestBody beer: Beer): Beer = beerRepository.save(beer)

    @GetMapping("/beers/{id}")
    fun getBeerById(@PathVariable(value = "id") beerId: Long): ResponseEntity<Beer> {
        return beerRepository.findById(beerId).map { beer -> ResponseEntity.ok(beer)}
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/beer/{id}")
    fun updateBeerById(@PathVariable(value = "id") beerId: Long, @Valid @RequestBody newBeer: Beer): ResponseEntity<Beer> {
        return beerRepository.findById(beerId).map { existingBeer -> val updatedBeer: Beer = existingBeer
                .copy(breweryName = newBeer.breweryName, beerName = newBeer.beerName, description = newBeer.description)
            ResponseEntity.ok().body(beerRepository.save(updatedBeer))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/beers/{id}")
    fun deleteBeerById(@PathVariable(value = "id") beerId: Long): ResponseEntity<Void> {
        return beerRepository.findById(beerId).map { beer  ->
            beerRepository.delete(beer)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}