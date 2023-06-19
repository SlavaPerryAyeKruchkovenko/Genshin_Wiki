package com.example.genshin_wiki.networks

import com.example.genshin_wiki.data.responses.WeaponDataResponse
import com.example.genshin_wiki.data.responses.WeaponsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeaponApi {
    @GET("weapons")
    suspend fun getWeapons(): Response<WeaponsListResponse>

    @GET("weapon/{weapon}")
    suspend fun getWeapon(@Path("weapon") weaponId: String): Response<WeaponDataResponse>
}