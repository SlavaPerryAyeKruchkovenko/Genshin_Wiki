package com.example.genshin_wiki.data.responses

import com.google.gson.annotations.SerializedName

data class ArtifactDataResponse(
    @SerializedName("data") val artifact: ArtifactResponse
)

