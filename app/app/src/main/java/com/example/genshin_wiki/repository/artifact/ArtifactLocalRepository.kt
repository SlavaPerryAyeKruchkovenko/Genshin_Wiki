package com.example.genshin_wiki.repository.artifact

import com.example.genshin_wiki.MainActivity
import com.example.genshin_wiki.database.entities.ArtifactEntity
import com.example.genshin_wiki.database.repositories.IArtifactLocalRepository

class ArtifactLocalRepository : IArtifactLocalRepository {
    override suspend fun addArtifacts(artifacts: List<ArtifactEntity>) {
        MainActivity.getArtifactDao()?.softInsertArtifacts(artifacts)
    }

    override suspend fun updateArtifact(artifact: ArtifactEntity) {
        MainActivity.getArtifactDao()?.update(artifact)
    }

    override suspend fun getArtifacts(): List<ArtifactEntity>? {
        return MainActivity.getArtifactDao()?.getAllArtifacts()
    }

    override suspend fun getLikedArtifacts(): List<ArtifactEntity>? {
        return MainActivity.getArtifactDao()?.getLikedArtifact()
    }

    override suspend fun getArtifact(id: String): ArtifactEntity? {
        return MainActivity.getArtifactDao()?.getArtifactById(id)
    }

}