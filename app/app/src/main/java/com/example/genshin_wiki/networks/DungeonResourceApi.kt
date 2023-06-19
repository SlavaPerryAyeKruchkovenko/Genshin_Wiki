package com.example.genshin_wiki.networks

import com.example.genshin_wiki.data.responses.DungeonResourceListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DungeonResourceApi {
    @GET("dungeonResource/{day}")
    suspend fun getResources(@Path("day") dayOfWeek: String): Response<DungeonResourceListResponse>
}