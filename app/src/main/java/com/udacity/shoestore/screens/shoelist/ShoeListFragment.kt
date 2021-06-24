package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoelistFragmentBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListFragment: Fragment() {

    private lateinit var binding : ShoelistFragmentBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.shoelist_fragment, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)

        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        binding.floatingButton.setOnClickListener {
            Timber.e("Clicked!")
            view!!.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            inflateList()
        })



        return binding.root

    }

    private fun inflateList() {
        Timber.e("Inflating list!")
        viewModel.shoeList.value?.forEach { shoe ->
//            val shoeRow = DataBindingUtil.inflate(layoutInflater, R.layout.list_row, binding.linearLayout, false)
            val shoeRow = layoutInflater.inflate(R.layout.list_row, binding.linearLayout, false)

            val nameText = shoeRow.findViewById<TextView>(R.id.nameText)
            val sizeText = shoeRow.findViewById<TextView>(R.id.sizeText)
            val companyText = shoeRow.findViewById<TextView>(R.id.companyText)
            val descriptionText = shoeRow.findViewById<TextView>(R.id.descriptionText)
            val imageText = shoeRow.findViewById<TextView>(R.id.imageText)

            nameText.text = shoe.name
            sizeText.text = shoe.size.toString()
            companyText.text = shoe.company
            descriptionText.text = shoe.description

            if (shoe.images.isEmpty()) {
                imageText.text = getString(R.string.missing_images)
            } else {
                val stringBuffer = StringBuffer()
                shoe.images.forEachIndexed { index, it ->
                    stringBuffer.append(it)
                    if (index < shoe.images.size - 1) {
                        stringBuffer.append('\n')
                    }
                }
                imageText.text = stringBuffer.toString()
            }

            binding.linearLayout.addView(shoeRow)
        }
    }
}