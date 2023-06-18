package com.example.genshin_wiki.data.requests

import com.google.gson.annotations.SerializedName

data class DungeonResourceRequest(
    @SerializedName("_id") val id: String,
    @SerializedName("dayOfWeek") val day: Int,
    @SerializedName("location") val location: String,
    @SerializedName("city") val city: String,
    @SerializedName("image") val image: String
)