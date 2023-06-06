package com.example.beerslistv6.data.model

//beer 01
const val name = "Corona"
const val type = "Pilsner"

//beer 02

const val name2 = "Heineken"
const val type2 = "Pilsen "

var beers = mutableListOf(
    BeerModel(name, type),
    BeerModel(name2, type2)
)