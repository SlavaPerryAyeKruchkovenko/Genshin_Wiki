package com.example.genshin_wiki.data.response

import com.google.gson.annotations.SerializedName

class CharacterListResponse (
    @SerializedName("data") val characters: List<CharacterResponse>
)