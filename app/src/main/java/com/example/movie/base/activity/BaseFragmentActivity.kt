package com.example.movie.base.activity

import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import com.example.movie.R
import com.example.movie.base.fragment.BaseFragment

abstract class BaseFragmentActivity : BaseActivity() {
    private var mTempToExitCount: Int = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        val fragment: BaseFragment = initFragment()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(getFragmentContainerId(), fragment)
                .commit()
        }

    }

    abstract fun initView()
    abstract fun getFragmentContainerId(): Int
    abstract fun initFragment(): BaseFragment
    open fun pushFragment(
        fragment: BaseFragment,
        tag: String,
        commitAllowingStateLoss: Boolean = false
    ) {
        replaceFragment(
            fragment = fragment,
            tag = tag,
            openEnter = R.anim.slide_in_right,
            openExit = R.anim.slide_out_left,
            closeEnter = R.anim.slide_in_left,
            closeExit = R.anim.slide_out_right,
            commitAllowingStateLoss = commitAllowingStateLoss
        )
    }

    private fun replaceFragment(
        fragment: BaseFragment,
        tag: String,
        openEnter: Int,
        openExit: Int,
        closeEnter: Int,
        closeExit: Int,
        commitAllowingStateLoss: Boolean = false
    ) {

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(openEnter, openExit, closeEnter, closeExit)
            .replace(getFragmentContainerId(), fragment, tag)
        if (tag.isNotEmpty()) {
            fragmentTransaction.addToBackStack(tag)
        }
        if (commitAllowingStateLoss) {
            fragmentTransaction.commitAllowingStateLoss()
        } else {
            fragmentTransaction.commit()
        }
    }

    open fun addFragment(fragment: BaseFragment, tag: String, animation: Boolean = false) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        if (animation) {
            fragmentTransaction.setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
        }

        fragmentTransaction.add(getFragmentContainerId(), fragment)
        if (tag.isNotEmpty()) {
            fragmentTransaction.addToBackStack(tag)
        }
        fragmentTransaction.commit()

    }

}