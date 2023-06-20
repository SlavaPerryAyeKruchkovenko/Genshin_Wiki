package com.example.genshin_wiki.domain.interfaces.artifact

import com.example.genshin_wiki.data.converters.ArtifactConvert

interface ILikeArtifactUseCase {
    suspend operator fun invoke(artifact: ArtifactConvert): ArtifactConvert
}