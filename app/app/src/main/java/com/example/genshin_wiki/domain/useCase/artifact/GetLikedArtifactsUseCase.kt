package com.example.genshin_wiki.domain.useCase.artifact

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.domain.interfaces.artifact.IGetLikedArtifactsUseCase
import com.example.genshin_wiki.repository.artifact.ArtifactRepository

class GetLikedArtifactsUseCase : IGetLikedArtifactsUseCase {
    override suspend fun invoke(): List<ArtifactConvert> {
        val repository = ArtifactRepository()
        return repository.getLikedArtifacts()
    }
}