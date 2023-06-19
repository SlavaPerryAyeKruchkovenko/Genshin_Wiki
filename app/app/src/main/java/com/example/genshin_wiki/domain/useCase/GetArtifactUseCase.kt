package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.domain.interfaces.IGetArtifactUseCase
import com.example.genshin_wiki.repository.artifact.ArtifactRepository

class GetArtifactUseCase: IGetArtifactUseCase {
    override suspend fun invoke(id: String): ArtifactConvert {
        val repository = ArtifactRepository()
        return repository.getArtifactById(id)
    }
}