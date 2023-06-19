package com.example.genshin_wiki.data.responses

import com.google.gson.annotations.SerializedName

data class ArtifactResponse(
    @SerializedName("_id") val id: String = "",
    @SerializedName("bonus2") val bonus2: String = "",
    @SerializedName("bonus4") val bonus4: String = "",
    @SerializedName("countOfStars") val stars: Int = 5,
    @SerializedName("image") val image: String = ""
)