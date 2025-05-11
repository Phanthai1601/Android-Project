package com.example.movie.module.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.movie.R
import com.example.movie.base.fragment.BaseBindingFragment
import com.example.movie.databinding.FragmentCategoryBinding

class FragmentCategory: BaseBindingFragment<FragmentCategoryBinding>() {
    companion object{
        fun newInstance(): FragmentCategory{
            val fragment = FragmentCategory()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCategoryBinding
        get() = FragmentCategoryBinding::inflate

    override fun init() {}

    override fun getLayoutResId(): Int = R.layout.fragment_category
}