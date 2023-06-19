package com.example.genshin_wiki.repository.dungeon_resource

import android.util.Log
import com.example.genshin_wiki.data.converters.DungeonResourceConvert
import com.example.genshin_wiki.repository.interfaces.IDungeonResourceRepository

class DungeonResourceRepository : IDungeonResourceRepository {
    override suspend fun getResources(dayOfWeek: String): List<DungeonResourceConvert> {
        return try {
            val networkRepository = DungeonResourceNetworkRepository()
            val res = networkRepository.getResources(dayOfWeek)
            if (res.isSuccessful) {
                val response = res.body()!!
                val resources = response.resources
                resources.map {
                    DungeonResourceConvert.fromDungeonResourceResponse(it)
                }
            } else {
                listOf()
            }
        } catch (e: Exception) {
            Log.e("dungeon resources api error", e.toString())
            listOf()
        }
    }
}