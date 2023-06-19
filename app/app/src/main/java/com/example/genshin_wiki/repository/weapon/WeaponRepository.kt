package com.example.genshin_wiki.repository.weapon

import android.util.Log
import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.repository.interfaces.IWeaponRepository

class WeaponRepository : IWeaponRepository {
    override suspend fun getAllWeapons(): List<WeaponConverter> {
        val networkRepository = WeaponNetworkRepository()
        val localRepository = WeaponLocalRepository()
        return try {
            val res = networkRepository.getWeapons()
            if (res.isSuccessful) {
                val response = res.body()!!
                val resWeapons = response.weapons
                val weapons = resWeapons.map {
                    WeaponConverter.fromWeaponResponse(it)
                }
                val weaponsEntity = weapons.map {
                    it.toWeaponEntity()
                }
                localRepository.addWeapons(weaponsEntity)
                weapons
            } else {
                localRepository.getWeapons()?.map {
                    WeaponConverter.fromWeaponEntity(it)
                } ?: listOf()

            }
        } catch (_:Exception) {
            localRepository.getWeapons()?.map {
                WeaponConverter.fromWeaponEntity(it)
            } ?: listOf()
        }
    }

    override suspend fun getWeaponById(id: String): WeaponConverter {
        val networkRepository = WeaponNetworkRepository()
        val localRepository = WeaponLocalRepository()
        return try {
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