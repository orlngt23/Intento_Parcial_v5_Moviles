package com.example.beerslistv6.data.adapter

import android.icu.text.UnicodeSetIterator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beerslistv6.data.model.BeerModel
import com.example.beerslistv6.databinding.FragmentItemBeerBinding

class BeerRecyclerViewAdapter (
    private val clickListener: (BeerModel)->Unit
): RecyclerView.Adapter<BeerRecyclerViewHolder>(){
    private val beers = ArrayList<BeerModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerRecyclerViewHolder {
        val binding = FragmentItemBeerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BeerRecyclerViewHolder(binding)
    }

    override fun getItemCount() = beers.size

    override fun onBindViewHolder(holder: BeerRecyclerViewHolder, position: Int) {
        val beer = beers[position]
        holder.bind(beer,clickListener)
    }
    fun setData(beerList: List<BeerModel>){
        beers.clear()
        beers.addAll(beerList)
    }
}

