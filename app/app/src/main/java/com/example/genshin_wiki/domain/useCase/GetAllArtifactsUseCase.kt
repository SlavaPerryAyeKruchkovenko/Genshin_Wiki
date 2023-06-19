package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.domain.interfaces.IGetAllArtifactsUseCase
import com.example.genshin_wiki.repository.artifact.ArtifactRepository

class GetAllArtifactsUseCase : IGetAllArtifactsUseCase {
    override suspend fun invoke(): List<ArtifactConvert> {
        val repository = ArtifactRepository()
        return repository.getAllArtifacts()
    }
}