package com.example.movie.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.movie.R
import com.example.movie.base.fragment.BaseBindingFragment
import com.example.movie.databinding.FragmentHomeBinding

class HomeFragment : BaseBindingFragment<FragmentHomeBinding>() {
    companion object{
        fun newInstance(): HomeFragment{
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun init() {}

    override fun getLayoutResId(): Int = R.layout.fragment_home
}