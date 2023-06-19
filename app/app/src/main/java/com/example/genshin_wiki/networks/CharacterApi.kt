package com.example.genshin_wiki.networks

import com.example.genshin_wiki.data.responses.ArtifactDataResponse
import com.example.genshin_wiki.data.responses.CharacterDataResponse
import com.example.genshin_wiki.data.responses.CharacterListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {
    @GET("characters")
    suspend fun getCharacters(): Response<CharacterListResponse>
    @GET("character/{character}")
    suspend fun getCharacter(@Path("character") characterId: String): Response<CharacterDataResponse>
}