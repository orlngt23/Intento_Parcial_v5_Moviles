package com.example.beerslistv6.ui.main.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.beerslistv6.R
import com.example.beerslistv6.databinding.FragmentFormBeerBinding
import com.example.beerslistv6.databinding.FragmentItemBeerBinding

/**
 * A simple [Fragment] subclass.
 * Use the [itemBeer.newInstance] factory method to
 * create an instance of this fragment.
 */
class itemBeer : Fragment() {
    private lateinit var binding: FragmentItemBeerBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBeerBinding.inflate(inflater, container, false)
        return binding.root
    }
}