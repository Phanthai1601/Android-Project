package com.example.movie.module.movie

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movie.model.response.MovieDetailResponse
import com.example.movie.module.movie.detail.EpisodesFragment
import com.example.movie.module.movie.detail.SimilarMovieFragment

class ViewPaperAdapter(activity: FragmentActivity,

): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> EpisodesFragment()
            1 -> SimilarMovieFragment()
            else -> throw IllegalStateException("Invalid tab position: $position")
        }
    }

}