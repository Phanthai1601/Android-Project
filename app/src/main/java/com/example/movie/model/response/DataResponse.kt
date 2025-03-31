package com.example.movie.model.response

import com.google.gson.annotations.SerializedName

data class DataResponse<T>(
    @SerializedName("data")
    var dataResponse: T
) : BaseDataResponse()
