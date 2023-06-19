package com.example.genshin_wiki.domain.interfaces

import com.example.genshin_wiki.data.converters.ArtifactConvert

interface IGetArtifactUseCase {
    suspend operator fun invoke(id: String): ArtifactConvert
}