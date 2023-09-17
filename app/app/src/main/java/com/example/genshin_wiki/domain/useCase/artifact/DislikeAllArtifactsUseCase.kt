package com.example.genshin_wiki.domain.useCase.artifact

import com.example.genshin_wiki.domain.interfaces.artifact.IDislikeAllArtifactsUseCase
import com.example.genshin_wiki.repository.artifact.ArtifactRepository

class DislikeAllArtifactsUseCase(private val repository: ArtifactRepository): IDislikeAllArtifactsUseCase {
    override suspend fun invoke(): Boolean {
        return repository.dislikeArtifacts()
    }
}