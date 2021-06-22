package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    private val _login = MutableLiveData<String>()
    val login: LiveData<String>
        get() = _login

    private val _pass = MutableLiveData<String>()
    val pass: LiveData<String>
        get() = _pass

    init {
        _login.value = ""
        _pass.value = ""
    }


}