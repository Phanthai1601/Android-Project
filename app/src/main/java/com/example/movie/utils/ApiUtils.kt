package com.example.movie.utils

import android.content.Context

object ApiUtils {
    fun getCurrentBaseUrl(context: Context): String {
        return Constants.URL.BASE_URL
    }
}