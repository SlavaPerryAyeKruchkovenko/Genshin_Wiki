package com.example.genshin_wiki.repository.dungeon_resource

import com.example.genshin_wiki.data.responses.DungeonResourceListResponse
import com.example.genshin_wiki.networks.DungeonResourceApi
import com.example.genshin_wiki.networks.repositories.IDungeonResourceNetworkRepository
import retrofit2.Response

class DungeonResourceNetworkRepository(private val api: DungeonResourceApi) :
    IDungeonResourceNetworkRepository {
    override suspend fun getResources(dayOfWeek: String): Response<DungeonResourceListResponse> {
        return api.getResources(dayOfWeek)
    }
}