package com.example.genshin_wiki.di.modules.domainModules

import com.example.genshin_wiki.domain.interfaces.character.*
import com.example.genshin_wiki.domain.useCase.character.*
import org.koin.dsl.module

val characterDomainModule = module {
    factory<IDislikeAllCharactersUseCase> {
        DislikeAllCharactersUseCase(repository = get())
    }
    factory<IDislikeCharacterUseCase> {
        DislikeCharacterUseCase(repository = get())
    }
    factory<IGetAllCharactersUseCase> {
        GetAllCharactersUseCase(repository = get())
    }
    factory<IGetCharacterUseCase> {
        GetCharacterUseCase(repository = get())
    }
    factory<IGetLikedCharacterUseCase> {
        GetLikedCharactersUseCase(repository = get())
    }
    factory<ILikeCharacterUseCase> {
        LikeCharacterUseCase(repository = get())
    }
}