package com.example.movie.module.home

import android.content.Context
import android.content.Intent
import com.example.movie.R
import com.example.movie.base.activity.BaseFragmentActivity
import com.example.movie.base.fragment.BaseFragment

class HomeActivity : BaseFragmentActivity() {
    companion object{
        fun makeIntent(
            context: Context
        ): Intent{
            val intent = Intent(context, HomeActivity::class.java)
            return intent
        }
    }
    override fun initView() {
        setContentView(R.layout.activity_home)
    }

    override fun getFragmentContainerId(): Int = R.id.container

    override fun initFragment(): BaseFragment = HomeFragment.newInstance()

    override fun changeStatusBarTextColor(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getLayoutResId(): Int  = R.layout.activity_home
}