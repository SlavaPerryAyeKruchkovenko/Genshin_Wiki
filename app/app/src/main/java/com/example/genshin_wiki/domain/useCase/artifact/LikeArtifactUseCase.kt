package com.example.genshin_wiki.domain.useCase.artifact

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.domain.interfaces.artifact.ILikeArtifactUseCase
import com.example.genshin_wiki.repository.artifact.ArtifactRepository

class LikeArtifactUseCase: ILikeArtifactUseCase {

    override suspend fun invoke(artifact: ArtifactConvert): ArtifactConvert {
        val repository = ArtifactRepository()
        artifact.isLiked = true
        return repository.updateArtifact(artifact)
    }
}