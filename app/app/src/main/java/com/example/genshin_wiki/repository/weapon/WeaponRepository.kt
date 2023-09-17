package com.example.genshin_wiki.repository.weapon

import android.util.Log
import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.database.repositories.IWeaponLocalRepository
import com.example.genshin_wiki.networks.repositories.IWeaponNetworkRepository
import com.example.genshin_wiki.repository.interfaces.IWeaponRepository

class WeaponRepository(
    private val local: IWeaponLocalRepository,
    private val network: IWeaponNetworkRepository
) : IWeaponRepository {
    override suspend fun getAllWeapons(): List<WeaponConverter> {
        return try {
            val res = network.getWeapons()
            if (res.isSuccessful) {
                val response = res.body()!!
                val resWeapons = response.weapons
                val weapons = resWeapons.map {
                    WeaponConverter.fromWeaponResponse(it)
                }
                val weaponsEntity = weapons.map {
                    it.toWeaponEntity()
                }
                local.addWeapons(weaponsEntity)
                weapons
            } else {
                local.getWeapons()?.map {
                    WeaponConverter.fromWeaponEntity(it)
                } ?: listOf()
            }
        } catch (e: Exception) {
            Log.e("get weapons error", e.toString())
            local.getWeapons()?.map {
                WeaponConverter.fromWeaponEntity(it)
            } ?: listOf()
        }
    }

    override suspend fun getWeaponById(id: String): WeaponConverter {
        return try {
            val weaponEntity = local.getWeapon(id)
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
        return try {
            val weaponEntity = local.getWeapon(weapon.id)
            if (weaponEntity != null) {
                weaponEntity.isLike = if (weapon.isLiked) {
                    1
                } else {
                    0
                }
                local.updateWeapon(weaponEntity)
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
        return try {
            local.getLikedWeapons()?.map {
                WeaponConverter.fromWeaponEntity(it)
            } ?: listOf()
        } catch (e: Exception) {
            Log.e("liked weapons error", e.toString())
            listOf()
        }
    }

    override suspend fun dislikeWeapons(): Boolean {
        return try {
            local.dislikeWeapons()
            true
        } catch (e: Exception){
            Log.e("dislike weapons error", e.toString())
            false
        }
    }
}