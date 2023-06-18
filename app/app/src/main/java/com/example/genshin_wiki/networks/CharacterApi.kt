package com.example.genshin_wiki.networks

import com.example.genshin_wiki.data.requests.CharacterRequest
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {
    @GET("character")
    suspend fun getCharacter(): Response<List<CharacterRequest>>
}