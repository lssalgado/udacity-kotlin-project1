package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel : ViewModel() {
    private val _shoeList: MutableLiveData<ArrayList<Shoe>>
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList

    init {
        _shoeList = MutableLiveData(arrayListOf(
            Shoe("AirMax", 40.0, "Nike", "description 1"),
            Shoe("AirMin", 1.0, "Keni", "description 2", arrayListOf("Top demais", "meu amigo"))
        ))
    }

    fun addShoe(shoe: Shoe) {
        val array = ArrayList<Shoe>()
        _shoeList.value?.let {
            array.addAll(it)
        }
        array.add(shoe)
        _shoeList.value = array
    }
}