package com.mysoso.nursetrackingserver.ui.server

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ServerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Server Fragment"
    }
    val text: LiveData<String> = _text
}