package com.example.movie.model

import com.google.gson.annotations.SerializedName

data class Imdb(
    @SerializedName("id") var id: String? = null

)
