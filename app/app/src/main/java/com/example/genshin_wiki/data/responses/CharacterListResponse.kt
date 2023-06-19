package com.example.genshin_wiki.data.responses

import com.google.gson.annotations.SerializedName

data class CharacterListResponse (
    @SerializedName("data") val characters: List<CharacterResponse>
)