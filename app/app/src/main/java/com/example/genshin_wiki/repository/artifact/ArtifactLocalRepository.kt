package com.example.genshin_wiki.repository.artifact

import com.example.genshin_wiki.database.dao.ArtifactDao
import com.example.genshin_wiki.database.entities.ArtifactEntity
import com.example.genshin_wiki.database.repositories.IArtifactLocalRepository

class ArtifactLocalRepository(private val dao: ArtifactDao) : IArtifactLocalRepository {
    override suspend fun addArtifacts(artifacts: List<ArtifactEntity>) {
        dao.softInsertArtifacts(artifacts)
    }

    override suspend fun updateArtifact(artifact: ArtifactEntity) {
        dao.update(artifact)
    }

    override suspend fun getArtifacts(): List<ArtifactEntity> {
        return dao.getAllArtifacts()
    }

    override suspend fun getLikedArtifacts(): List<ArtifactEntity> {
        return dao.getLikedArtifact()
    }

    override suspend fun getArtifact(id: String): ArtifactEntity? {
        return dao.getArtifactById(id)
    }

    override suspend fun dislikeArtifacts() {
        dao.dislikeAllArtifacts()
    }
}