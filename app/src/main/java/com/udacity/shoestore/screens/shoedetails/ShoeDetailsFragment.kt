package com.udacity.shoestore.screens.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoedetailsFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: ShoedetailsFragmentBinding
    private lateinit var viewModel: MainActivityViewModel
    private val shoe = Shoe("", 0.0, "", "")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoedetails_fragment, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)

        binding.shoe = shoe

        binding.cancelBt.setOnClickListener {
            view!!.findNavController().navigateUp()
        }

        binding.saveBt.setOnClickListener {
            viewModel.addShoe(shoe)
            view!!.findNavController().navigateUp()
        }

        return binding.root
    }
}