package com.example.genshin_wiki.repository.weapon

import android.util.Log
import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.repository.character.CharacterNetworkRepository
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
        return try {
            val networkRepository = WeaponNetworkRepository()
            val res = networkRepository.getWeapon(id)
            if (res.isSuccessful) {
                val data = res.body()!!
                val weapon = data.weapon
                WeaponConverter.fromWeaponResponse(weapon)
            } else {
                WeaponConverter.default()
            }
        } catch (e: Exception) {
            Log.e("weapon by id api error", e.toString())
            WeaponConverter.default()
        }
    }
}