package com.example.movie.model.response

import com.google.gson.annotations.SerializedName

open class BaseDataResponse {
    @SerializedName("ecode")
    var responseCode: String = ""
    @SerializedName("message")
    var responseMessage: String = ""
}