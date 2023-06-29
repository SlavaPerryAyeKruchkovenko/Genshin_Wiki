package com.example.genshin_wiki.domain.useCase.artifact

import com.example.genshin_wiki.domain.interfaces.artifact.IDislikeAllArtifactsUseCase
import com.example.genshin_wiki.repository.artifact.ArtifactRepository

class DislikeAllArtifactsUseCase: IDislikeAllArtifactsUseCase {
    override suspend fun invoke(): Boolean {
        val repository = ArtifactRepository()
        return repository.dislikeArtifacts()
    }
}