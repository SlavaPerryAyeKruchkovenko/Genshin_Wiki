package com.example.genshin_wiki.networks

import com.example.genshin_wiki.data.response.DungeonResourceResponse
import retrofit2.Response
import retrofit2.http.GET

interface DungeonResourceApi {
    @GET("dungeonResource")
    suspend fun getCharacter(): Response<List<DungeonResourceResponse>>
}