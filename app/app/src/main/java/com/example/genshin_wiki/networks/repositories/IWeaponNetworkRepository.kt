package com.example.genshin_wiki.networks.repositories

import com.example.genshin_wiki.data.responses.WeaponDataResponse
import com.example.genshin_wiki.data.responses.WeaponResponse
import com.example.genshin_wiki.data.responses.WeaponsListResponse
import retrofit2.Response

interface IWeaponNetworkRepository {
    suspend fun getWeapons(): Response<WeaponsListResponse>
    suspend fun getWeapon(id: String): Response<WeaponDataResponse>
}