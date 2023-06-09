package com.example.beerslistv6.data.adapter

import android.annotation.SuppressLint
import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.beerslistv6.data.model.BeerModel
import com.example.beerslistv6.databinding.FragmentItemBeerBinding

class BeerRecyclerViewHolder(private val binding: FragmentItemBeerBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(
        beer: BeerModel, clickListener: (BeerModel)->Unit
    ) {
        binding.textViewNameBeer.text = beer.name
        binding.textViewTypeBeer.text = beer.type

        binding.cardItem.setOnClickListener{
            clickListener(beer)
        }
    }
}