package com.example.movie.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie.model.AppMessage

open class BaseViewModel : ViewModel() {
    protected var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    open fun initialize() {
    }

    private var _appMessage = MutableLiveData<AppMessage>()
    val appMessage: LiveData<AppMessage>
        get() = _appMessage

}