package com.example.movie.repository

import android.content.Context
import android.util.Log
import com.example.movie.model.Movie
import com.example.movie.model.response.ListMovieDetailResponse
import com.example.movie.model.response.ListMovieResponse
import com.example.movie.network.ApiRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieRepository {
    fun getListMovie(
        context: Context,
        page: Int,
        onSuccess: (ListMovieResponse) -> Unit,
        onError: (message: String) -> Unit
    ) {
        ApiRequest.getInstance().init(context)
        ApiRequest.getInstance().getListMovie(page,
            object : Callback<ListMovieResponse> {
                override fun onResponse(
                    p0: Call<ListMovieResponse>,
                    p1: Response<ListMovieResponse>
                ) {
                    val response = p1.body()
                    if (response != null) {
                        onSuccess.invoke(response)
                    }
                }

                override fun onFailure(p0: Call<ListMovieResponse>, p1: Throwable) {

                }

            }
        )


    }
    fun getListMovieDetail(
        context: Context,
        slug: String,
        onSuccess: (Movie) -> Unit,
        onError: (message: String) -> Unit
    ){
        ApiRequest.getInstance().init(context)
        ApiRequest.getInstance().getDetailMovie(
            slug,
            object : Callback<ListMovieDetailResponse>{
                override fun onFailure(p0: Call<ListMovieDetailResponse>, p1: Throwable) {

                }

                override fun onResponse(
                    p0: Call<ListMovieDetailResponse>,
                    p1: Response<ListMovieDetailResponse>
                ) {

                    val response = p1.body()
                    if(response!= null){
                        Log.d("json", response.movie.toString())
                        onSuccess.invoke(response.movie)
                    }

                }
            }
        )
    }


}
