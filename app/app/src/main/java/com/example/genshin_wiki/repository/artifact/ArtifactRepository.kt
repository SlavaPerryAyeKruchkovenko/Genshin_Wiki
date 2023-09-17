package com.example.genshin_wiki.repository.artifact

import android.util.Log
import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.database.repositories.IArtifactLocalRepository
import com.example.genshin_wiki.networks.repositories.IArtifactNetworkRepository
import com.example.genshin_wiki.repository.interfaces.IArtifactRepository
import java.net.UnknownHostException

class ArtifactRepository(
    private val local: IArtifactLocalRepository,
    private val network: IArtifactNetworkRepository
) : IArtifactRepository {
    override suspend fun getAllArtifacts(): List<ArtifactConvert> {
        return try {
            val res = network.getArtifacts()
            if (res.isSuccessful) {
                val response = res.body()!!
                val resArtifacts = response.artifacts
                val artifacts = resArtifacts.map {
                    ArtifactConvert.fromArtifactResponse(it)
                }
                val artifactsEntity = artifacts.map {
                    it.toArtifactEntity()
                }
                local.addArtifacts(artifactsEntity)
                artifacts
            } else {
                local.getArtifacts()?.map {
                    ArtifactConvert.fromArtifactEntity(it)
                } ?: listOf()
            }
        } catch (e: UnknownHostException) {
            Log.e("get all artifacts error", e.toString())
            local.getArtifacts()?.map {
                ArtifactConvert.fromArtifactEntity(it)
            } ?: listOf()
        }
    }

    override suspend fun getArtifactById(id: String): ArtifactConvert {
        return try {
            val artifactEntity = local.getArtifact(id)
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
        return try {
            val artifactEntity = local.getArtifact(artifact.id)
            if (artifactEntity != null) {
                artifactEntity.isLike = if (artifact.isLiked) {
                    1
                } else {
                    0
                }
                local.updateArtifact(artifactEntity)
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
        return try {
            local.getLikedArtifacts()?.map {
                ArtifactConvert.fromArtifactEntity(it)
            } ?: listOf()
        } catch (e: Exception) {
            Log.e("liked artifacts error", e.toString())
            listOf()
        }
    }

    override suspend fun dislikeArtifacts(): Boolean {
        return try {
            local.dislikeArtifacts()
            true
        } catch (e: Exception){
            Log.e("dislike artifacts error", e.toString())
            false
        }
    }
}