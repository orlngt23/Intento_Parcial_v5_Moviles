package com.example.beerslistv6

import android.app.Application
import com.example.beerslistv6.data.model.beers
import com.example.beerslistv6.repository.repository

class BeerReviewerAplication: Application() {
    val beerRepository:repository by lazy {
        repository(beers)
    }
}