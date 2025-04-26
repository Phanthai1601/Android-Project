package com.example.movie.network


import com.example.movie.model.response.ListMovieResponse
import com.example.movie.model.response.MovieDetailResponse
import com.example.movie.model.response.SearchMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiPoint {
    @GET("danh-sach/phim-moi-cap-nhat")
    fun getListNewLyUpdatedMovie(@Query("page") page: Int): Call<ListMovieResponse>
    @GET("phim/{slug}")
    fun getMovieDetail(@Path("slug") slug: String): Call<MovieDetailResponse>
    @GET("/v1/api/tim-kiem")
    fun searchMovie(
        @Query("keyword") keyword: String,
        @Query("page")  page : Int,
        @Query("sort_field") sortField: String,
        @Query("sort_type")  sortType : String,
        @Query("limit") limit: Int
    ): Call<SearchMovieResponse>
}