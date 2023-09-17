package com.example.genshin_wiki.repository.artifact

import com.example.genshin_wiki.data.responses.ArtifactDataResponse
import com.example.genshin_wiki.data.responses.ArtifactListResponse
import com.example.genshin_wiki.networks.ArtifactApi
import com.example.genshin_wiki.networks.repositories.IArtifactNetworkRepository
import retrofit2.Response

class ArtifactNetworkRepository(private val api: ArtifactApi) : IArtifactNetworkRepository {
    override suspend fun getArtifacts(): Response<ArtifactListResponse> {
        return api.getArtifacts()
    }

    override suspend fun getArtifact(id: String): Response<ArtifactDataResponse> {
        return api.getArtifact(id)
    }
}