package com.example.genshin_wiki.domain.interfaces

import com.example.genshin_wiki.data.converters.ArtifactConvert

interface IGetAllArtifactsUseCase {
    suspend operator fun invoke(): List<ArtifactConvert>
}