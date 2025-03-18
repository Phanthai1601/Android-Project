package com.example.movie.model

import com.google.gson.annotations.SerializedName

data class Tmdb(
    @SerializedName("type") var type: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("season") var season: String? = null,
    @SerializedName("vote_average") var voteAverage: Int? = null,
    @SerializedName("vote_count") var voteCount: Int? = null
)
