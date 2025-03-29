package com.example.movie.network

import android.content.Context
import com.example.movie.model.response.ListMovieDetailResponse
import com.example.movie.model.response.ListMovieResponse
import com.example.movie.utils.ApiUtils
import com.google.gson.GsonBuilder
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


open class ApiRequest {
    private lateinit var mRetrofit: Retrofit
    private lateinit var mApiPoint: ApiPoint

    companion object {
        private lateinit var sInstance: ApiRequest
        fun getInstance(): ApiRequest {
            if (!this::sInstance.isInitialized) {
                synchronized(ApiRequest::class.java) {
                    sInstance = ApiRequest()
                }
            }
            return sInstance
        }
    }

    open fun init(context: Context) {
        val baseUrl = ApiUtils.getCurrentBaseUrl(context)

        mRetrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

        mApiPoint = mRetrofit.create(ApiPoint::class.java)
    }

    fun getListMovie(page : Int, callback: Callback<ListMovieResponse>) {
        mApiPoint.getListNewLyUpdatedMovie(page).enqueue(callback)
    }

}
