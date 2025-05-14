package com.example.movie.model

import com.google.gson.annotations.SerializedName

data class Params(
    @SerializedName("type_slug") var typeSlug: String? = null,
    @SerializedName("keyword") var keyword: String? = null,
    @SerializedName("filterCategory") var filterCategory: ArrayList<String> = arrayListOf(),
    @SerializedName("filterCountry") var filterCountry: ArrayList<String> = arrayListOf(),
    @SerializedName("filterYear") var filterYear: ArrayList<String> = arrayListOf(),
    @SerializedName("filterType") var filterType: ArrayList<String> = arrayListOf(),
    @SerializedName("sortField") var sortField: String? = null,
    @SerializedName("sortType") var sortType: String? = null,
    @SerializedName("pagination") var pagination: Pagination? = Pagination()

)
