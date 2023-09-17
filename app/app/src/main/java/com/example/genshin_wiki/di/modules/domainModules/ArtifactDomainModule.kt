package com.example.genshin_wiki.di.modules.domainModules

import com.example.genshin_wiki.database.repositories.*
import com.example.genshin_wiki.domain.interfaces.artifact.*
import com.example.genshin_wiki.domain.useCase.artifact.*
import org.koin.dsl.module

val artifactDomainModule = module {
    single<IDislikeAllArtifactsUseCase> {
        DislikeAllArtifactsUseCase(repository = get())
    }
    single<IDislikeArtifactUseCase> {
        DislikeArtifactUseCase(repository = get())
    }
    single<IGetAllArtifactsUseCase> {
        GetAllArtifactsUseCase(repository = get())
    }
    single<IGetArtifactUseCase> {
        GetArtifactUseCase(repository = get())
    }
    single<IGetLikedArtifactsUseCase> {
        GetLikedArtifactsUseCase(repository = get())
    }
    single<ILikeArtifactUseCase> {
        LikeArtifactUseCase(repository = get())
    }
}