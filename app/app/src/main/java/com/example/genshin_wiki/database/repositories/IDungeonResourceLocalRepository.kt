package com.example.genshin_wiki.database.repositories

import com.example.genshin_wiki.database.entities.DungeonResourceEntity

interface IDungeonResourceLocalRepository {
    suspend fun addResources(resources: List<DungeonResourceEntity>, day: Int)
    suspend fun getResources(day: Int): List<DungeonResourceEntity>?
}