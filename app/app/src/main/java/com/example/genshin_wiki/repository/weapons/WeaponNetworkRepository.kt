package com.example.genshin_wiki.repository.weapons

import com.example.genshin_wiki.data.responses.WeaponResponse
import com.example.genshin_wiki.data.responses.WeaponsListResponse
import com.example.genshin_wiki.networks.repositories.IWeaponNetworkRepository
import com.example.genshin_wiki.networks.RetrofitBuilder
import retrofit2.Response

class WeaponNetworkRepository: IWeaponNetworkRepository {
    override suspend fun getWeapons(): Response<WeaponsListResponse> {
        return RetrofitBuilder.weaponApi.getWeapons()
    }

    override suspend fun getWeapon(id: String): Response<WeaponResponse> {
        TODO("Not yet implemented")
    }
}