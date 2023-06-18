package com.example.genshin_wiki.data.requests

import com.google.gson.annotations.SerializedName

data class AbilityRequest(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String
)
