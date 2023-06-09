package com.example.beerslistv6.ui.main

import android.content.AbstractThreadedSyncAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.beerslistv6.R
import com.example.beerslistv6.data.adapter.BeerRecyclerViewAdapter
import com.example.beerslistv6.data.model.BeerModel
import com.example.beerslistv6.databinding.FragmentItemBeerBinding
import com.example.beerslistv6.databinding.FragmentMainBinding
import com.example.beerslistv6.ui.viewmodel.BeerViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [mainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class mainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: BeerRecyclerViewAdapter

    private val beerViewModel: BeerViewModel by activityViewModels {
        BeerViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        })

        listeners()
        recyclerView(view)

    }

    private fun listeners(){
        binding.btnAddBeer.setOnClickListener{
            beerViewModel.clearData()
            it.findNavController().navigate(R.id.action_mainFragment_to_formBeerFragment)
        }
    }
    private fun showSelectedItem(beer: BeerModel){
        beerViewModel.setSelectedBeer(beer)
        findNavController().navigate(R.id.action_mainFragment_to_viewBeerFragment)
    }

    private fun displayBeers(){
        adapter.setData(beerList = beerViewModel.getBeer())
        adapter.notifyDataSetChanged()
    }
    private fun recyclerView(view: View){
        binding.recyleViewBeer.layoutManager = LinearLayoutManager(view.context)

        adapter = BeerRecyclerViewAdapter { selectedEmployee ->
            showSelectedItem(selectedEmployee)
        }

        binding.recyleViewBeer.adapter = adapter
        displayBeers()
    }

    private fun onBackPressed(){
        val navController = Navigation.findNavController(requireView())
        val toast = Toast.makeText(requireContext(), "beers", Toast.LENGTH_SHORT)
        toast.show()
        if(navController.currentDestination?.id != R.id.mainFragment){
            navController.popBackStack()
        }
        else requireActivity().onBackPressed()
    }

}