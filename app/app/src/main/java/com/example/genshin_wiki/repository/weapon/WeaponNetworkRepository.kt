package com.example.genshin_wiki.repository.weapon

import com.example.genshin_wiki.data.responses.WeaponDataResponse
import com.example.genshin_wiki.data.responses.WeaponsListResponse
import com.example.genshin_wiki.networks.DungeonResourceApi
import com.example.genshin_wiki.networks.RetrofitBuilder
import com.example.genshin_wiki.networks.WeaponApi
import com.example.genshin_wiki.networks.repositories.IWeaponNetworkRepository
import retrofit2.Response

class WeaponNetworkRepository(private val api: WeaponApi): IWeaponNetworkRepository {
    override suspend fun getWeapons(): Response<WeaponsListResponse> {
        return api.getWeapons()
    }

    override suspend fun getWeapon(id: String): Response<WeaponDataResponse> {
        return api.getWeapon(id)
    }
}