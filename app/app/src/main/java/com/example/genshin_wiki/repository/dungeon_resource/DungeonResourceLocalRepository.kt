package com.example.genshin_wiki.repository.dungeon_resource

import com.example.genshin_wiki.MainActivity
import com.example.genshin_wiki.database.dao.CharacterDao
import com.example.genshin_wiki.database.dao.DungeonResourceDao
import com.example.genshin_wiki.database.entities.DungeonResourceEntity
import com.example.genshin_wiki.database.repositories.IDungeonResourceLocalRepository

class DungeonResourceLocalRepository(private val dao: DungeonResourceDao): IDungeonResourceLocalRepository {
    override suspend fun addResources(resources: List<DungeonResourceEntity>, day: Int) {
        dao.softInsertResources(resources,day)
    }

    override suspend fun getResources(day: Int): List<DungeonResourceEntity> {
        return dao.getResourcesByDay(day)
    }
}