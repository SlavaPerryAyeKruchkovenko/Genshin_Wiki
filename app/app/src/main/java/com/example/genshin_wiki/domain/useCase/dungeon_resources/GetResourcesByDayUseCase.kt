package com.example.genshin_wiki.domain.useCase.dungeon_resources

import com.example.genshin_wiki.data.converters.DungeonResourceConvert
import com.example.genshin_wiki.domain.helpers.ResourceDay
import com.example.genshin_wiki.domain.interfaces.dungeon_resource.IGetResourcesByDayUseCase
import com.example.genshin_wiki.repository.interfaces.IDungeonResourceRepository

class GetResourcesByDayUseCase(private val repository: IDungeonResourceRepository) :
    IGetResourcesByDayUseCase {
    override suspend fun invoke(day: ResourceDay): List<DungeonResourceConvert> {
        val resources = repository.getResources(day)
        return if (resources.any { it.location == "all" }) {
            listOf(resources.filter { it.location == "all" }.first())
        } else {
            val mondstadt = resources.filter { it.city.lowercase() == "mondstadt" }
            val liYue = resources.filter { it.city.lowercase() == "li yue" }
            val inadzuma = resources.filter { it.city.lowercase() == "inadzuma" }
            val sumeru = resources.filter { it.city.lowercase() == "sumeru" }
            mondstadt + liYue + inadzuma + sumeru
        }
    }
}