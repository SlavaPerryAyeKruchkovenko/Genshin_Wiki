package com.example.genshin_wiki.data.responses

import com.google.gson.annotations.SerializedName

data class CharacterDataResponse(
    @SerializedName("data") val character: CharacterResponse
)
