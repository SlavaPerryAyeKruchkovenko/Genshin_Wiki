package com.example.genshin_wiki.repository.artifact

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.data.responses.ArtifactDataResponse
import com.example.genshin_wiki.data.responses.ArtifactListResponse
import com.example.genshin_wiki.networks.RetrofitBuilder
import com.example.genshin_wiki.networks.repositories.IArtifactNetworkRepository
import retrofit2.Response

class ArtifactNetworkRepository : IArtifactNetworkRepository{
    override suspend fun getArtifacts(): Response<ArtifactListResponse> {
        return RetrofitBuilder.artifactApi.getArtifacts()
    }

    override suspend fun getArtifact(id: String): Response<ArtifactDataResponse> {
        return RetrofitBuilder.artifactApi.getArtifact(id)
    }
}