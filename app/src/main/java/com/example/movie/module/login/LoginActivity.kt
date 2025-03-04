package com.example.movie.module.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.movie.R
import com.example.movie.base.activity.BaseFragmentActivity
import com.example.movie.base.fragment.BaseFragment

class LoginActivity : BaseFragmentActivity() {
    companion object {
        fun makeIntent(
            context: Context,
        ): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        setContentView(R.layout.activity_login)
    }

    override fun getFragmentContainerId(): Int = R.id.container

    override fun initFragment(): BaseFragment = LoginFragment.newInstance()

    override fun changeStatusBarTextColor(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getLayoutResId(): Int = R.layout.activity_login

}