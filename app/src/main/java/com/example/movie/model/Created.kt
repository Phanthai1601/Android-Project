package com.example.movie.model

import com.google.gson.annotations.SerializedName

data class Created(
    @SerializedName("time") var time: String? = null

)
