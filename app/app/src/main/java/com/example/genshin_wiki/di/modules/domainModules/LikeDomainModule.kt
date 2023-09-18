package com.example.genshin_wiki.di.modules.domainModules

import com.example.genshin_wiki.domain.interfaces.IDislikeAllObjectsUseCase
import com.example.genshin_wiki.domain.interfaces.IGetLikedObjectsUseCase
import com.example.genshin_wiki.domain.useCase.DislikeAllObjectsUseCase
import com.example.genshin_wiki.domain.useCase.GetLikedObjectsUseCase
import com.example.genshin_wiki.domain.useCase.character.DislikeAllCharactersUseCase
import org.koin.dsl.module

val likeDomainModule = module {
    factory<IDislikeAllObjectsUseCase> {
        DislikeAllObjectsUseCase(get(),get(),get())
    }
    factory<IGetLikedObjectsUseCase> {
        GetLikedObjectsUseCase(get(),get(),get())
    }
}