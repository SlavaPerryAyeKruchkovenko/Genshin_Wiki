package com.example.genshin_wiki.networks.repositories

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.data.responses.ArtifactListResponse
import retrofit2.Response

interface IArtifactNetworkRepository {
    suspend fun getArtifacts(): Response<ArtifactListResponse>
    suspend fun getArtifact(id: String): Response<ArtifactConvert>
}