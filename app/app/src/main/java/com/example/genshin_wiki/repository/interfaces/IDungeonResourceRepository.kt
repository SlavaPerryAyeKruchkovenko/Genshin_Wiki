package com.example.genshin_wiki.repository.interfaces

import com.example.genshin_wiki.data.converters.DungeonResourceConvert
import com.example.genshin_wiki.domain.helpers.ResourceDay

interface IDungeonResourceRepository {
    suspend fun getResources(day: ResourceDay): List<DungeonResourceConvert>
}