package com.example.movie.base.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.example.movie.base.viewmodel.BaseViewModel

abstract class BaseMvvmActivity<ViewModelType : BaseViewModel> : BaseActivity() {
    protected var viewModel: ViewModelType? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = initViewModel()
        viewModel?.initialize()
        viewModel?.isLoading?.observe(this) { isLoading ->
            if (isLoading) {
                showLoading()
            } else {
                hideLoading()
            }
        }

        viewModel?.appMessage?.observe(this) { appMessage ->
            if (appMessage.message.isNotBlank()) {
                showMessage(appMessage.message)
            }
        }
    }

    abstract fun initViewModel(): ViewModelType

}