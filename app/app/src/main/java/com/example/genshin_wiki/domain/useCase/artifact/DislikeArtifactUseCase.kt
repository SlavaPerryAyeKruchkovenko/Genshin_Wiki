package com.example.genshin_wiki.domain.useCase.artifact

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.domain.interfaces.artifact.IDislikeArtifactUseCase
import com.example.genshin_wiki.repository.artifact.ArtifactRepository

class DislikeArtifactUseCase : IDislikeArtifactUseCase {
    override suspend fun invoke(artifact: ArtifactConvert): ArtifactConvert {
        val repository = ArtifactRepository()
        artifact.isLiked = false
        return repository.updateArtifact(artifact)
    }
}