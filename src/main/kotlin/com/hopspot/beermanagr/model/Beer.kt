package com.hopspot.beermanagr.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank

@Entity
data class Beer (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get: NotBlank
    val breweryName: String = "",

    @get: NotBlank
    val beerName: String = "",

    @get: NotBlank
    val description: String = ""

)