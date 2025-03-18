package com.example.movie.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null
)
