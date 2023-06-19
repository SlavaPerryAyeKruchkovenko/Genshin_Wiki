package com.example.genshin_wiki.repository.interfaces

import com.example.genshin_wiki.data.converters.DungeonResourceConvert

interface IDungeonResourceRepository {
    suspend fun getResources(dayOfWeek: String): List<DungeonResourceConvert>
}