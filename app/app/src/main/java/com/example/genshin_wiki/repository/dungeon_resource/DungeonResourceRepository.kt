package com.example.genshin_wiki.repository.dungeon_resource

import android.util.Log
import com.example.genshin_wiki.data.converters.DungeonResourceConvert
import com.example.genshin_wiki.database.repositories.IDungeonResourceLocalRepository
import com.example.genshin_wiki.domain.helpers.ResourceDay
import com.example.genshin_wiki.networks.repositories.IDungeonResourceNetworkRepository
import com.example.genshin_wiki.repository.interfaces.IDungeonResourceRepository
import java.net.UnknownHostException

class DungeonResourceRepository(
    private val local: IDungeonResourceLocalRepository,
    private val network: IDungeonResourceNetworkRepository
) : IDungeonResourceRepository {
    override suspend fun getResources(day: ResourceDay): List<DungeonResourceConvert> {
        val dayOfWeek = day.ordinal + 1
        val entityDay = if (dayOfWeek % 3 == 0) {
            3
        } else {
            dayOfWeek % 3
        }
        if (dayOfWeek < 7) {
            return try {
                val res = network.getResources(day.name.lowercase())
                if (res.isSuccessful) {
                    val response = res.body()!!
                    val resResources = response.resources
                    val resources = resResources.map {
                        DungeonResourceConvert.fromDungeonResourceResponse(it)
                    }
                    val resourcesEntity = resources.map {
                        it.toDungeonResourceEntity(entityDay)
                    }
                    local.addResources(resourcesEntity, entityDay)
                    resources
                } else {
                    local.getResources(entityDay)?.map {
                        DungeonResourceConvert.fromDungeonResourceEntity(it)
                    } ?: listOf()
                }
            } catch (e: UnknownHostException) {
                Log.e("dungeon resources api error", e.toString())
                local.getResources(entityDay)?.map {
                    DungeonResourceConvert.fromDungeonResourceEntity(it)
                } ?: listOf()
            }
        }
        return listOf(DungeonResourceConvert.sunday())
    }
}