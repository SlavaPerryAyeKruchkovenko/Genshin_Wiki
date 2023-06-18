package com.example.genshin_wiki.networks

import com.example.genshin_wiki.data.requests.WeaponRequest
import retrofit2.Response
import retrofit2.http.GET

interface WeaponApi {
    @GET("weapons")
    suspend fun getWeapons(): Response<List<WeaponRequest>>
}