package com.example.genshin_wiki.data.response

import com.google.gson.annotations.SerializedName

data class DungeonResourceResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("dayOfWeek") val day: Int,
    @SerializedName("location") val location: String,
    @SerializedName("city") val city: String,
    @SerializedName("image") val image: String
)