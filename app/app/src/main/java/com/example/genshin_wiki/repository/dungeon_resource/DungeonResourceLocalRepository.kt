package com.example.genshin_wiki.repository.dungeon_resource

import com.example.genshin_wiki.MainActivity
import com.example.genshin_wiki.database.entities.DungeonResourceEntity
import com.example.genshin_wiki.database.repositories.IDungeonResourceLocalRepository

class DungeonResourceLocalRepository: IDungeonResourceLocalRepository {
    override suspend fun addResources(resources: List<DungeonResourceEntity>, day: Int) {
        MainActivity.getResourceDao()?.softInsertResources(resources,day)
    }

    override suspend fun getResources(day: Int): List<DungeonResourceEntity>? {
        return MainActivity.getResourceDao()?.getResourcesByDay(day)
    }
}