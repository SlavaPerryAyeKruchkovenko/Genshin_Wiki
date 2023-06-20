package com.example.genshin_wiki.repository.interfaces

import com.example.genshin_wiki.data.converters.WeaponConverter

interface IWeaponRepository {
    suspend fun getAllWeapons(): List<WeaponConverter>
    suspend fun getWeaponById(id: String): WeaponConverter
    suspend fun updateWeapon(weapon:WeaponConverter): WeaponConverter
    suspend fun getLikedWeapons(): List<WeaponConverter>
}