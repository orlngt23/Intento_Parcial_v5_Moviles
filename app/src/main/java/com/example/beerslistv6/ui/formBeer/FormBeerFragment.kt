package com.example.beerslistv6.ui.formBeer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

import com.example.beerslistv6.R
import com.example.beerslistv6.databinding.FragmentFormBeerBinding
import com.example.beerslistv6.ui.viewmodel.BeerViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [formBeerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class formBeerFragment : Fragment() {
    private lateinit var binding: FragmentFormBeerBinding
    private val beerViewModel: BeerViewModel by activityViewModels<BeerViewModel> {
        BeerViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFormBeerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        sentStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = beerViewModel
    }

    private fun sentStatus(){
        beerViewModel.status.observe(viewLifecycleOwner){
            when{
                it.equals(BeerViewModel.WRONG_INFORMATION)->{
                    val toast = Toast.makeText(requireContext(),BeerViewModel.WRONG_INFORMATION, Toast.LENGTH_SHORT)
                    toast.show()
                }
                it.equals(BeerViewModel.BEER_ADDED)->{
                    val toast = Toast.makeText(requireContext(),BeerViewModel.BEER_ADDED, Toast.LENGTH_SHORT)
                    toast.show()
                    beerViewModel.createBeer()
                    findNavController().popBackStack()
                }
            }
        }
    }

}