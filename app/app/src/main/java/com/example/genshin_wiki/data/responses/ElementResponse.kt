package com.example.genshin_wiki.data.responses

import com.google.gson.annotations.SerializedName

data class ElementResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String
)
