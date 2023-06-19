package com.example.genshin_wiki.repository.artifact

import android.util.Log
import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.repository.interfaces.IArtifactRepository

class ArtifactRepository : IArtifactRepository {
    override suspend fun getAllArtifacts(): List<ArtifactConvert> {
        return try {
            val networkRepository = ArtifactNetworkRepository()
            val res = networkRepository.getArtifacts()
            if (res.isSuccessful) {
                val response = res.body()!!
                val artifacts = response.artifacts
                artifacts.map {
                    ArtifactConvert.fromArtifactResponse(it)
                }
            } else {
                listOf()
            }
        } catch (e: Exception) {
            Log.e("artifacts api error", e.toString())
            listOf()
        }
    }

    override suspend fun getArtifactById(id: String): ArtifactConvert {
        return try {
            val networkRepository = ArtifactNetworkRepository()
            val res = networkRepository.getArtifact(id)
            if (res.isSuccessful) {
                val data = res.body()!!
                val artifact = data.artifact
                ArtifactConvert.fromArtifactResponse(artifact)
            } else {
                ArtifactConvert.default()
            }
        } catch (e: Exception) {
            Log.e("artifact by id api error", e.toString())
            ArtifactConvert.default()
        }
    }
}