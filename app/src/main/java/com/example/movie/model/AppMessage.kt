package com.example.movie.model

data class AppMessage(
    val message: String,
    val type: AppMessageType = AppMessageType.NONE
)
