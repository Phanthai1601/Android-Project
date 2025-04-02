package com.example.movie.repository

import android.content.Context
import android.util.Log
import com.bumptech.glide.load.HttpException
import com.example.movie.model.Items
import com.example.movie.model.Movie
import com.example.movie.model.response.ListMovieResponse
import com.example.movie.model.response.MovieDetailResponse
import com.example.movie.network.ApiRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

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
    fun getMovieDetail(
        context: Context,
        slug: String,
        onSuccess: (MovieDetailResponse)->Unit,
        onError: (message: String) -> Unit
    ){
        ApiRequest.getInstance().init(context)
        ApiRequest.getInstance().getMovieDetail(slug,
            object :Callback<MovieDetailResponse>{
                override fun onResponse(
                    p0: Call<MovieDetailResponse>,
                    p1: Response<MovieDetailResponse>
                ) {
                    val response = p1.body()
                    if(response!=null){
                        onSuccess.invoke(response)
                    }
                }

                override fun onFailure(p0: Call<MovieDetailResponse>, p1: Throwable) {
                    Log.e("API_ERROR", "Request failed", p1)

                    when (p1) {
                        is IOException -> {
                            // Lỗi kết nối mạng
                            Log.e("API_ERROR_DEMO", "Network failure, please check your internet connection.")
                        }
                        is HttpException -> {
                            // Lỗi HTTP từ server
                            Log.e("API_ERROR_DEMO1", "HTTP error: ${p1.message}")
                        }
                        else -> {
                            // Lỗi không xác định
                            Log.e("API_ERROR_DEMO2", "Unexpected error: ${p1.localizedMessage}")
                        }
                    }
                }


            }
        )
    }


}
