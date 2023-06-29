package com.example.genshin_wiki.domain.interfaces.artifact

import com.example.genshin_wiki.data.converters.ArtifactConvert

interface IDislikeAllArtifactsUseCase {
    suspend operator fun invoke(): Boolean
}