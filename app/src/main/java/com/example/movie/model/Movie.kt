package com.example.movie.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("tmdb") var tmdb: Tmdb? = Tmdb(),
    @SerializedName("imdb") var imdb: Imdb? = Imdb(),
    @SerializedName("created") var created: Created? = Created(),
    @SerializedName("modified") var modified: Modified? = Modified(),
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("origin_name") var originName: String? = null,
    @SerializedName("content") var content: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("poster_url") var posterUrl: String? = null,
    @SerializedName("thumb_url") var thumbUrl: String? = null,
    @SerializedName("is_copyright") var isCopyright: Boolean? = null,
    @SerializedName("sub_docquyen") var subDocquyen: Boolean? = null,
    @SerializedName("chieurap") var chieurap: Boolean? = null,
    @SerializedName("trailer_url") var trailerUrl: String? = null,
    @SerializedName("time") var time: String? = null,
    @SerializedName("episode_current") var episodeCurrent: String? = null,
    @SerializedName("episode_total") var episodeTotal: String? = null,
    @SerializedName("quality") var quality: String? = null,
    @SerializedName("lang") var lang: String? = null,
    @SerializedName("notify") var notify: String? = null,
    @SerializedName("showtimes") var showtimes: String? = null,
    @SerializedName("year") var year: Int? = null,
    @SerializedName("view") var view: Int? = null,
    @SerializedName("actor") var actor: ArrayList<String> = arrayListOf(),
    @SerializedName("director") var director: ArrayList<String> = arrayListOf(),
    @SerializedName("category") var category: ArrayList<Category> = arrayListOf(),
    @SerializedName("country") var country: ArrayList<Country> = arrayListOf()

)
