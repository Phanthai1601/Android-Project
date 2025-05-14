package com.example.movie.model



import com.google.gson.annotations.SerializedName


data class Item(

    @SerializedName("modified") var modified: Modified? = Modified(),
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("origin_name") var originName: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("poster_url") var posterUrl: String? = null,
    @SerializedName("thumb_url") var thumbUrl: String? = null,
    @SerializedName("sub_docquyen") var subDocquyen: Boolean? = null,
    @SerializedName("chieurap") var chieurap: Boolean? = null,
    @SerializedName("time") var time: String? = null,
    @SerializedName("episode_current") var episodeCurrent: String? = null,
    @SerializedName("quality") var quality: String? = null,
    @SerializedName("lang") var lang: String? = null,
    @SerializedName("year") var year: Int? = null,
    @SerializedName("category") var category: ArrayList<Category> = arrayListOf(),
    @SerializedName("country") var country: ArrayList<Country> = arrayListOf()

)