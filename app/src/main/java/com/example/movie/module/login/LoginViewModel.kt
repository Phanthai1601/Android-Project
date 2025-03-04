package com.example.movie.module.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movie.base.viewmodel.BaseViewModel

class LoginViewModel : BaseViewModel() {
    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult

    fun login(username: String, password: String) {
        // Giả lập kiểm tra đăng nhập
        _loginResult.value = username == "admin" && password == "1234"
    }
}