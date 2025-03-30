package com.example.movie.network


import com.example.movie.model.response.ListMovieResponse
import com.example.movie.model.response.MovieDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiPoint {
    @GET("danh-sach/phim-moi-cap-nhat")
    fun getListNewLyUpdatedMovie(@Query("page") page: Int): Call<ListMovieResponse>
    @GET("phim/{slug}")
    fun getMovieDetail(@Path("slug") slug: String): Call<MovieDetailResponse>
}