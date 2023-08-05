package com.example.genshin_wiki.repository.dungeon_resource

import android.util.Log
import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.data.converters.DungeonResourceConvert
import com.example.genshin_wiki.domain.helpers.ResourceDay
import com.example.genshin_wiki.repository.interfaces.IDungeonResourceRepository
import java.net.UnknownHostException

class DungeonResourceRepository : IDungeonResourceRepository {
    override suspend fun getResources(day: ResourceDay): List<DungeonResourceConvert> {
        val networkRepository = DungeonResourceNetworkRepository()
        val localRepository = DungeonResourceLocalRepository()
        val dayOfWeek = day.ordinal + 1
        val entityDay = if (dayOfWeek % 3 == 0) {
            3
        } else {
            dayOfWeek % 3
        }
        if (dayOfWeek < 7) {
            return try {
                val res = networkRepository.getResources(day.name.lowercase())
                if (res.isSuccessful) {
                    val response = res.body()!!
                    val resResources = response.resources
                    val resources = resResources.map {
                        DungeonResourceConvert.fromDungeonResourceResponse(it)
                    }
                    val resourcesEntity = resources.map {
                        it.toDungeonResourceEntity(entityDay)
                    }
                    localRepository.addResources(resourcesEntity, entityDay)
                    resources
                } else {
                    localRepository.getResources(entityDay)?.map {
                        DungeonResourceConvert.fromDungeonResourceEntity(it)
                    } ?: listOf()
                }
            } catch (e: UnknownHostException) {
                Log.e("dungeon resources api error", e.toString())
                localRepository.getResources(entityDay)?.map {
                    DungeonResourceConvert.fromDungeonResourceEntity(it)
                } ?: listOf()
            }
        }
        return listOf(DungeonResourceConvert.sunday())
    }
}