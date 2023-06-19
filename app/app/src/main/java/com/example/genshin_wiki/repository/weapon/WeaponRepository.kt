package com.example.genshin_wiki.repository.weapon

import android.util.Log
import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.repository.interfaces.IWeaponRepository

class WeaponRepository : IWeaponRepository {
    override suspend fun getAllWeapons(): List<WeaponConverter> {
        return try {
            val networkRepository = WeaponNetworkRepository()
            val res = networkRepository.getWeapons()
            if (res.isSuccessful) {
                val response = res.body()!!
                val weapons = response.weapons
                weapons.map {
                    WeaponConverter.fromWeaponResponse(it)
                }
            } else {
                listOf()
            }
        } catch (e: Exception) {
            Log.e("weapon api error", e.toString())
            listOf()
        }
    }

    override suspend fun getWeaponById(id: String): WeaponConverter {
        TODO("Not yet implemented")
    }
}