package com.example.genshin_wiki.repository.interfaces

import com.example.genshin_wiki.data.converters.ArtifactConvert

interface IArtifactRepository {
    suspend fun getAllArtifacts(): List<ArtifactConvert>
    suspend fun getArtifactById(id: String): ArtifactConvert
    suspend fun updateArtifact(artifact: ArtifactConvert): ArtifactConvert
    suspend fun getLikedArtifacts(): List<ArtifactConvert>
    suspend fun dislikeArtifacts(): Boolean
}