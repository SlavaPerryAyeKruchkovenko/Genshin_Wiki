package com.example.genshin_wiki.data.requests

import com.google.gson.annotations.SerializedName

data class ElementRequest(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String
)
