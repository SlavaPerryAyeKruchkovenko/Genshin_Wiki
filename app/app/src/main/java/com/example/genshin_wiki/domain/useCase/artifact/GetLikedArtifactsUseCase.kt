package com.example.genshin_wiki.domain.useCase.artifact

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.domain.interfaces.artifact.IGetLikedArtifactsUseCase
import com.example.genshin_wiki.repository.artifact.ArtifactRepository

class GetLikedArtifactsUseCase(private val repository: ArtifactRepository) : IGetLikedArtifactsUseCase {
    override suspend fun invoke(): List<ArtifactConvert> {
        return repository.getLikedArtifacts()
    }
}