package com.example.beerslistv6.ui.viewBeer

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

import com.example.beerslistv6.R
import com.example.beerslistv6.databinding.FragmentItemBeerBinding
import com.example.beerslistv6.databinding.FragmentViewBeerBinding
import com.example.beerslistv6.ui.viewmodel.BeerViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [viewBeerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class viewBeerFragment : Fragment() {

    private lateinit var binding: FragmentViewBeerBinding
    private val beerViewModel: BeerViewModel by activityViewModels {
        BeerViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentViewBeerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }
    private fun setViewModel(){
        binding.viewmodel = beerViewModel
    }
}