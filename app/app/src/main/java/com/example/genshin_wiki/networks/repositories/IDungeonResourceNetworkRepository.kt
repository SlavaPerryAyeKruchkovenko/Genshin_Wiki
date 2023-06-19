package com.example.genshin_wiki.networks.repositories

import com.example.genshin_wiki.data.responses.DungeonResourceListResponse
import retrofit2.Response

interface IDungeonResourceNetworkRepository {
    suspend fun getResources(dayOfWeek: String): Response<DungeonResourceListResponse>
}