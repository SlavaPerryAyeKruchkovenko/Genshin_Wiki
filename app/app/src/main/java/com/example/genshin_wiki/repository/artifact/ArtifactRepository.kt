package com.example.genshin_wiki.repository.artifact

import android.util.Log
import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.repository.interfaces.IArtifactRepository
import java.net.UnknownHostException

class ArtifactRepository : IArtifactRepository {
    override suspend fun getAllArtifacts(): List<ArtifactConvert> {
        val networkRepository = ArtifactNetworkRepository()
        val localRepository = ArtifactLocalRepository()
        return try {
            val res = networkRepository.getArtifacts()
            if (res.isSuccessful) {
                val response = res.body()!!
                val resArtifacts = response.artifacts
                val artifacts = resArtifacts.map {
                    ArtifactConvert.fromArtifactResponse(it)
                }
                val artifactsEntity = artifacts.map {
                    it.toArtifactEntity()
                }
                localRepository.addArtifacts(artifactsEntity)
                artifacts
            } else {
                localRepository.getArtifacts()?.map {
                    ArtifactConvert.fromArtifactEntity(it)
                } ?: listOf()
            }
        } catch (e: UnknownHostException) {
            Log.e("get all artifacts error", e.toString())
            localRepository.getArtifacts()?.map {
                ArtifactConvert.fromArtifactEntity(it)
            } ?: listOf()
        }
    }

    override suspend fun getArtifactById(id: String): ArtifactConvert {
        val localRepository = ArtifactLocalRepository()
        return try {
            val artifactEntity = localRepository.getArtifact(id)
            if (artifactEntity != null) {
                ArtifactConvert.fromArtifactEntity(artifactEntity)
            } else {
                ArtifactConvert.default()
            }
        } catch (e: UnknownHostException) {
            Log.e("get artifact by id error", e.toString())
            ArtifactConvert.default()
        }
    }

    override suspend fun updateArtifact(artifact: ArtifactConvert): ArtifactConvert {
        val localRepository = ArtifactLocalRepository()
        return try {
            val artifactEntity = localRepository.getArtifact(artifact.id)
            if (artifactEntity != null) {
                artifactEntity.isLike = if (artifact.isLiked) {
                    1
                } else {
                    0
                }
                localRepository.updateArtifact(artifactEntity)
                ArtifactConvert.fromArtifactEntity(artifactEntity)
            } else {
                ArtifactConvert.default()
            }
        } catch (e: Exception) {
            Log.e("update artifact error", e.toString())
            ArtifactConvert.default()
        }
    }

    override suspend fun getLikedArtifacts(): List<ArtifactConvert> {
        val localRepository = ArtifactLocalRepository()
        return try {
            localRepository.getLikedArtifacts()?.map {
                ArtifactConvert.fromArtifactEntity(it)
            } ?: listOf()
        } catch (e: Exception) {
            Log.e("liked artifacts error", e.toString())
            listOf()
        }
    }

    override suspend fun dislikeArtifacts(): Boolean {
        val localRepository = ArtifactLocalRepository()
        return try {
            localRepository.dislikeArtifacts()
            true
        } catch (e: Exception){
            Log.e("dislike artifacts error", e.toString())
            false
        }
    }
}