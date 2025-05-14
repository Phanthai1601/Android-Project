package com.example.movie.model

import com.google.gson.annotations.SerializedName

data class BreadCrumb(
    @SerializedName("name") var name: String? = null,
    @SerializedName("isCurrent") var isCurrent: Boolean? = null,
    @SerializedName("position") var position: Int? = null

)
