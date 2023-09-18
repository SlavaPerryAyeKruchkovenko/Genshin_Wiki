package com.example.genshin_wiki.di.modules.domainModules

import com.example.genshin_wiki.domain.interfaces.dungeon_resource.IGetResourcesByDayUseCase
import com.example.genshin_wiki.domain.useCase.dungeon_resources.GetResourcesByDayUseCase
import org.koin.dsl.module

val dungeonResourceDomainModule = module {
    factory<IGetResourcesByDayUseCase> {
        GetResourcesByDayUseCase(repository = get())
    }
}