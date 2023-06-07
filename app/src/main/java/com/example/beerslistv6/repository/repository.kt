package com.example.beerslistv6.repository

import com.example.beerslistv6.data.model.BeerModel

class repository ( private val beers: MutableList<BeerModel>){
    fun getBeers() = beers

    fun setBeer(newBeers: BeerModel) = beers.add(newBeers)
}