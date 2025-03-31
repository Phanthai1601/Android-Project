package com.example.movie.model.response

import com.example.movie.model.Items
import com.example.movie.model.Pagination
import com.google.gson.annotations.SerializedName

data class ListMovieResponse(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("items") var items: ArrayList<Items> = ArrayList(),
    @SerializedName("pagination") var pagination: Pagination? = Pagination()
)
