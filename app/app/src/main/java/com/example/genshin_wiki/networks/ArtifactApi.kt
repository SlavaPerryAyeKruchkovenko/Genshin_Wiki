package com.example.genshin_wiki.networks

import com.example.genshin_wiki.data.requests.ArtifactRequest
import retrofit2.Response
import retrofit2.http.GET

interface ArtifactApi {
    @GET("artifacts")
    suspend fun getArtifacts(): Response<List<ArtifactRequest>>
}