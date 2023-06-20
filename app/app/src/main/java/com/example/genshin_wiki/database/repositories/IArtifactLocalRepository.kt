package com.example.genshin_wiki.database.repositories

import com.example.genshin_wiki.database.entities.ArtifactEntity

interface IArtifactLocalRepository {
    suspend fun addArtifacts(artifacts: List<ArtifactEntity>)
    suspend fun updateArtifact(artifact: ArtifactEntity)
    suspend fun getArtifacts(): List<ArtifactEntity>?
    suspend fun getLikedArtifacts(): List<ArtifactEntity>?
    suspend fun getArtifact(id: String): ArtifactEntity?
}