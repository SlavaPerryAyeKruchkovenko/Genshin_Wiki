package com.example.genshin_wiki.di.modules.domainModules

import com.example.genshin_wiki.database.repositories.*
import com.example.genshin_wiki.domain.interfaces.artifact.*
import com.example.genshin_wiki.domain.useCase.artifact.*
import org.koin.dsl.module

val artifactDomainModule = module {
    factory<IDislikeAllArtifactsUseCase> {
        DislikeAllArtifactsUseCase(repository = get())
    }
    factory<IDislikeArtifactUseCase> {
        DislikeArtifactUseCase(repository = get())
    }
    factory<IGetAllArtifactsUseCase> {
        GetAllArtifactsUseCase(repository = get())
    }
    factory<IGetArtifactUseCase> {
        GetArtifactUseCase(repository = get())
    }
    factory<IGetLikedArtifactsUseCase> {
        GetLikedArtifactsUseCase(repository = get())
    }
    factory<ILikeArtifactUseCase> {
        LikeArtifactUseCase(repository = get())
    }
}