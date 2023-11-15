package com.hopspot.beermanagr.repository

import com.hopspot.beermanagr.model.Beer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BeerRepository: JpaRepository<Beer, Long>