package com.example.movie.repository

import android.content.Context
import android.util.Log
import com.example.movie.model.Items
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
        onSuccess: (ArrayList<Items>) -> Unit,
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
                        onSuccess.invoke(response.items)
                    }
                }

                override fun onFailure(p0: Call<ListMovieResponse>, p1: Throwable) {

                }

            }
        )


    }



}
