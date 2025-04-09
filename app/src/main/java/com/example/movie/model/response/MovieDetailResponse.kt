package com.example.movie.model.response

import android.os.Parcel
import android.os.Parcelable
import com.example.movie.model.Episodes
import com.example.movie.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("msg") var msg: String? = null,
    @SerializedName("movie") var movie: Movie = Movie(),
    @SerializedName("episodes") var episodes: ArrayList<Episodes> = arrayListOf()
)
