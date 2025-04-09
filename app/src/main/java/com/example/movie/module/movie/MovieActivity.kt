package com.example.movie.module.movie

import android.content.Context
import android.content.Intent
import com.example.movie.R
import com.example.movie.base.activity.BaseFragmentActivity
import com.example.movie.base.fragment.BaseFragment
import com.example.movie.module.login.LoginActivity

class MovieActivity : BaseFragmentActivity() {
    companion object {
        fun makeIntent(
            context: Context,
        ): Intent {
            val intent = Intent(context, MovieActivity::class.java)
            return intent

        }
    }
    override fun initView() {
        setContentView(R.layout.activity_movie)
    }

    override fun getFragmentContainerId(): Int = R.id.container

    override fun initFragment(): BaseFragment{
        val slug = intent.getStringExtra("Slug")?:""
        val nameMovie = intent.getStringExtra("nameMovie")?:""
        val year= intent.getIntExtra("year",2025)
        return MovieDetailFragment.newInstance(slug, nameMovie, year)
    }

    override fun changeStatusBarTextColor(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getLayoutResId(): Int = R.layout.activity_movie
}