package com.example.genshin_wiki.domain.interfaces.artifact

import com.example.genshin_wiki.data.converters.ArtifactConvert

interface IGetLikedArtifactsUseCase {
    suspend operator fun invoke(): List<ArtifactConvert>
}