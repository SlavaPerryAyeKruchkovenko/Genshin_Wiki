package com.example.genshin_wiki.networks

import com.example.genshin_wiki.data.responses.ArtifactDataResponse
import com.example.genshin_wiki.data.responses.ArtifactListResponse
import com.example.genshin_wiki.data.responses.ArtifactResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtifactApi {
    @GET("artifacts")
    suspend fun getArtifacts(): Response<ArtifactListResponse>
    @GET("artifact/{artifact}")
    suspend fun getArtifact(@Path("artifact") artifactId: String): Response<ArtifactDataResponse>
}