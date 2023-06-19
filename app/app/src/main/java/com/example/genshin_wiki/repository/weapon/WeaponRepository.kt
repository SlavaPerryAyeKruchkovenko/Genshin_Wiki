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
        } catch (e: Exception) {
            Log.e("get weapons error", e.toString())
            localRepository.getWeapons()?.map {
                WeaponConverter.fromWeaponEntity(it)
            } ?: listOf()
        }
    }

    override suspend fun getWeaponById(id: String): WeaponConverter {
        val localRepository = WeaponLocalRepository()
        return try {
            val weaponEntity = localRepository.getWeapon(id)
            if (weaponEntity != null) {
                WeaponConverter.fromWeaponEntity(weaponEntity)
            } else {
                WeaponConverter.default()
            }
        } catch (e: Exception) {
            Log.e("get weapon by id error", e.toString())
            WeaponConverter.default()
        }
    }

    override suspend fun updateWeapon(weapon: WeaponConverter): WeaponConverter {
        val localRepository = WeaponLocalRepository()
        return try {
            val weaponEntity = localRepository.getWeapon(weapon.id)
            if (weaponEntity != null) {
                weaponEntity.isLike = if (weapon.isLiked) {
                    1
                } else {
                    0
                }
                localRepository.updateWeapon(weaponEntity)
                WeaponConverter.fromWeaponEntity(weaponEntity)
            } else {
                WeaponConverter.default()
            }
        } catch (e: Exception) {
            Log.e("update weapon error", e.toString())
            WeaponConverter.default()
        }
    }

    override suspend fun getLikedWeapons(): List<WeaponConverter> {
        val localRepository = WeaponLocalRepository()
        return try {
            localRepository.getLikedWeapons()?.map {
                WeaponConverter.fromWeaponEntity(it)
            } ?: listOf()
        } catch (e: Exception) {
            Log.e("liked weapons error", e.toString())
            listOf()
        }
    }
}