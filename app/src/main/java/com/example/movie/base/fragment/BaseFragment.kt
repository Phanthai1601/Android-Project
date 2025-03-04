package com.example.movie.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movie.base.activity.BaseFragmentActivity

abstract class BaseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    abstract fun getLayoutResId(): Int
    protected fun pushFragment(
        fragment: BaseFragment,
        tag: String,
        commitAllowingStateLoss: Boolean = false
    ) {
        getFragmentActivity().pushFragment(fragment, tag, commitAllowingStateLoss)
    }

    private fun getFragmentActivity(): BaseFragmentActivity {
        return activity as BaseFragmentActivity
    }

    protected open fun addFragment(
        fragment: BaseFragment,
        tag: String,
        animation: Boolean = false
    ) {
        getFragmentActivity().addFragment(fragment, tag, animation)
    }


}