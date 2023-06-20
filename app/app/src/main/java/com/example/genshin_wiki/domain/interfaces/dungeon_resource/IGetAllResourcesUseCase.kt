package com.example.genshin_wiki.domain.interfaces.dungeon_resource

import com.example.genshin_wiki.data.converters.DungeonResourceConvert
import com.example.genshin_wiki.data.models.enums.Day
import com.example.genshin_wiki.domain.helpers.ResourceDay

interface IGetAllResourcesUseCase {
    suspend operator fun invoke(day: ResourceDay): List<DungeonResourceConvert>
}