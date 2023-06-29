package com.example.genshin_wiki.database.repositories

import com.example.genshin_wiki.database.entities.WeaponEntity

interface IWeaponLocalRepository {
    suspend fun addWeapons(weapons: List<WeaponEntity>)
    suspend fun updateWeapon(weapon: WeaponEntity)
    suspend fun getWeapons(): List<WeaponEntity>?
    suspend fun getLikedWeapons(): List<WeaponEntity>?
    suspend fun getWeapon(id: String): WeaponEntity?
    suspend fun dislikeWeapons()
}