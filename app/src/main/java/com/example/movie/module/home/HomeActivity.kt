package com.example.movie.module.home

import MovieFragment
import android.content.Context
import android.content.Intent
import com.example.movie.R
import com.example.movie.base.activity.BaseFragmentActivity
import com.example.movie.base.fragment.BaseFragment
import com.example.movie.module.category.FragmentCategory
import com.example.movie.module.search.MovieSearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : BaseFragmentActivity() {

    companion object {
        fun makeIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    private lateinit var bottomNavigation: BottomNavigationView

    override fun initView() {
        setContentView(R.layout.activity_home)

        bottomNavigation = findViewById(R.id.navigation)

        bottomNavigation.setOnItemSelectedListener { item ->
            val (fragment, tag) = when (item.itemId) {
                R.id.action_home -> MovieFragment.newInstance() to "home"
                R.id.action_search -> MovieSearchFragment.newInstance() to "search"
                R.id.action_video -> FragmentCategory.newInstance() to "category"
                else -> null to null
            }

            if (fragment != null && tag != null) {
                replaceFragment(
                    fragment = fragment,
                    tag = "",
                    openEnter = 0,
                    openExit = 0,
                    closeEnter = 0,
                    closeExit = 0,
                    commitAllowingStateLoss = false
                )
            }

            true
        }

    }

    override fun getFragmentContainerId(): Int = R.id.container

    override fun initFragment(): BaseFragment = MovieFragment.newInstance()

    override fun changeStatusBarTextColor(): Boolean = true

    override fun getLayoutResId(): Int = R.layout.activity_home
}
