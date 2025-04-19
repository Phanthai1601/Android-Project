package com.example.movie.module.movie.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movie.R
import com.example.movie.base.fragment.BaseBindingFragment
import com.example.movie.databinding.FragmentSimilarMovieBinding

class SimilarMovieFragment: BaseBindingFragment<FragmentSimilarMovieBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSimilarMovieBinding
        get() = FragmentSimilarMovieBinding::inflate

    override fun init() {}

    override fun getLayoutResId(): Int  = R.layout.fragment_similar_movie
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_similar_movie, container, false)
    }
}