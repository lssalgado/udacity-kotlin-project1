package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel : ViewModel() {
    private val _shoeList: MutableLiveData<ArrayList<Shoe>> = MutableLiveData(arrayListOf(
        Shoe("AirMax", 40.0, "Nike", "This is an AirMax"),
        Shoe("AirMin", 1.0, "Keni", "And this is an AirMin", arrayListOf("First image", "Second Image"))
    ))
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList

    fun addShoe(shoe: Shoe) {
        val array = ArrayList<Shoe>()
        _shoeList.value?.let {
            array.addAll(it)
        }
        array.add(shoe)
        _shoeList.value = array
    }
}