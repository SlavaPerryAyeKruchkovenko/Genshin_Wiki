package com.example.genshin_wiki.networks

import com.example.genshin_wiki.data.responses.CharacterListResponse
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun getCharacter(): Response<CharacterListResponse>
}