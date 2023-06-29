package com.example.genshin_wiki.domain.interfaces.dungeon_resource

import com.example.genshin_wiki.data.converters.DungeonResourceConvert
import com.example.genshin_wiki.domain.helpers.ResourceDay

interface IGetResourcesByDayUseCase {
    suspend operator fun invoke(day: ResourceDay): List<DungeonResourceConvert>
}