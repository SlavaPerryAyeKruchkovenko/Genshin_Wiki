package com.example.genshin_wiki.domain.useCase.artifact

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.domain.interfaces.artifact.IGetArtifactUseCase
import com.example.genshin_wiki.repository.artifact.ArtifactRepository

class GetArtifactUseCase(private val repository: ArtifactRepository): IGetArtifactUseCase {
    override suspend fun invoke(id: String): ArtifactConvert {
        return repository.getArtifactById(id)
    }
}