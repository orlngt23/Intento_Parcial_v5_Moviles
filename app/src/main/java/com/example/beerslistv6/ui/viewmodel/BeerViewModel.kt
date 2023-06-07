package com.example.beerslistv6.ui.viewmodel

import android.text.Spannable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.beerslistv6.BeerReviewerAplication
import com.example.beerslistv6.data.model.BeerModel
import com.example.beerslistv6.repository.repository

class BeerViewModel (private val repository: repository):ViewModel(){
    val Name = MutableLiveData("")
    val Type = MutableLiveData("")
    val status = MutableLiveData("")



    fun getBeer() = repository.getBeers()

    private fun addBeer(beer: BeerModel)=repository.setBeer(beer)

    private fun validateData(): Boolean{
        when{
            Name.value.isNullOrBlank()->return false
            Type.value.isNullOrBlank()->return false
        }
        return true
    }

    fun createBeer(): String{
      if(!validateData()){
         status.value = "Wrong Information"
          return "Wrong Information"
      }
      val beer = BeerModel(
          name = Name.value!!,
          type = Type.value!!
      )
      addBeer(beer)
      status.value = "Beer added "
      return "Beer added"
    }

    fun clearStatus(){
        status.value = ""
    }

    fun setSelectedBeer(beer: BeerModel){
        Name.value = beer.name
        Type.value = beer.type
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val beerRepository = (this[APPLICATION_KEY] as BeerReviewerAplication).beerRepository
                BeerViewModel(beerRepository)
            }
        }
    }

}