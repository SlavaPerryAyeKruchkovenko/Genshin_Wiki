package com.example.genshin_wiki.domain.useCase.artifact

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.domain.interfaces.artifact.IGetAllArtifactsUseCase
import com.example.genshin_wiki.repository.interfaces.IArtifactRepository

class GetAllArtifactsUseCase(private val repository: IArtifactRepository) :
    IGetAllArtifactsUseCase {
    override suspend fun invoke(): List<ArtifactConvert> {
        return repository.getAllArtifacts()
    }
}