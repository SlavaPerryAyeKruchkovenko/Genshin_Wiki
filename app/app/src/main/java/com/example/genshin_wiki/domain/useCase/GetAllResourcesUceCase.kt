package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.data.converters.DungeonResourceConvert
import com.example.genshin_wiki.domain.helpers.ResourceDay
import com.example.genshin_wiki.domain.interfaces.IGetAllResourcesUseCase
import com.example.genshin_wiki.repository.dungeon_resource.DungeonResourceRepository

class GetAllResourcesUceCase : IGetAllResourcesUseCase {
    override suspend fun invoke(day: ResourceDay): List<DungeonResourceConvert> {
        val repository = DungeonResourceRepository()
        val resources = repository.getResources(day.name.lowercase())
        val mondstadt = resources.filter { it.city.lowercase() == "mondstadt" }
        val liYue = resources.filter { it.city.lowercase() == "li yue" }
        val inadzuma = resources.filter { it.city.lowercase() == "inadzuma" }
        val sumeru = resources.filter { it.city.lowercase() == "sumeru" }
        return mondstadt + liYue + inadzuma + sumeru
    }
}