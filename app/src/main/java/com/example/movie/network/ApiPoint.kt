package com.example.movie.network

import com.example.movie.model.response.ListMovieDetailResponse
import com.example.movie.model.response.ListMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiPoint {
    @GET("danh-sach/phim-moi-cap-nhat")
    fun getListNewLyUpdatedMovie(@Query("page") page: Int): Call<ListMovieResponse>
    @GET("phim")
    fun getDetailMovie(@Query("slug") slug: String): Call<ListMovieDetailResponse>
}