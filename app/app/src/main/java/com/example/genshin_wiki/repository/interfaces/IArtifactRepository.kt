package com.example.genshin_wiki.repository.interfaces

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.data.converters.CharacterConvert

interface IArtifactRepository {
    suspend fun getAllArtifacts(): List<ArtifactConvert>
    suspend fun getArtifactById(id: String): ArtifactConvert
}