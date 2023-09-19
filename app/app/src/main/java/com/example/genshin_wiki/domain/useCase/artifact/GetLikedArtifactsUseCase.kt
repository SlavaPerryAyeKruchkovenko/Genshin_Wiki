package com.example.genshin_wiki.domain.useCase.artifact

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.domain.interfaces.artifact.IGetLikedArtifactsUseCase
import com.example.genshin_wiki.repository.interfaces.IArtifactRepository

class GetLikedArtifactsUseCase(private val repository: IArtifactRepository) :
    IGetLikedArtifactsUseCase {
    override suspend fun invoke(): List<ArtifactConvert> {
        return repository.getLikedArtifacts()
    }
}