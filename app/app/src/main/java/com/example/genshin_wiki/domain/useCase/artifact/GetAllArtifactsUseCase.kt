package com.example.genshin_wiki.domain.useCase.artifact

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.domain.interfaces.artifact.IGetAllArtifactsUseCase
import com.example.genshin_wiki.repository.artifact.ArtifactRepository

class GetAllArtifactsUseCase : IGetAllArtifactsUseCase {
    override suspend fun invoke(): List<ArtifactConvert> {
        val repository = ArtifactRepository()
        return repository.getAllArtifacts()
    }
}