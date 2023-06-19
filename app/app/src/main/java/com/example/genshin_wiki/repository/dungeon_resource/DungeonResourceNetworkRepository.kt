package com.example.genshin_wiki.repository.dungeon_resource

import com.example.genshin_wiki.data.responses.DungeonResourceListResponse
import com.example.genshin_wiki.networks.RetrofitBuilder
import com.example.genshin_wiki.networks.repositories.IDungeonResourceNetworkRepository
import retrofit2.Response

class DungeonResourceNetworkRepository : IDungeonResourceNetworkRepository {
    override suspend fun getResources(dayOfWeek: String): Response<DungeonResourceListResponse> {
        return RetrofitBuilder.resourceApi.getResources(dayOfWeek)
    }
}