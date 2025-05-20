package com.example.movie.utils

import android.content.Context

object ApiUtils {
    fun getCurrentBaseUrl(): String {
        return Constants.URL.BASE_URL
    }
    fun getBaseUrlImage(): String {
        return Constants.URL.BASE_URL_IMAGE
    }
}