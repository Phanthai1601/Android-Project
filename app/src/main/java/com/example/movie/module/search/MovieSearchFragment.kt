package com.example.movie.module.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.movie.R
import com.example.movie.base.fragment.BaseBindingFragment
import com.example.movie.databinding.FragmentListMovieSearchBinding

class MovieSearchFragment : BaseBindingFragment<FragmentListMovieSearchBinding>() {
    companion object{
        fun newInstance(): MovieSearchFragment{
            val fragment = MovieSearchFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
    }
    }
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentListMovieSearchBinding
        get() = FragmentListMovieSearchBinding::inflate

    override fun init() {}

    override fun getLayoutResId(): Int  = R.layout.fragment_list_movie_search
}