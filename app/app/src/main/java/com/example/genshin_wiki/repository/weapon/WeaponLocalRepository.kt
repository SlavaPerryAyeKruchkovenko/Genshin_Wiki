package com.example.genshin_wiki.repository.weapon

import android.util.Log
import com.example.genshin_wiki.MainActivity
import com.example.genshin_wiki.database.entities.WeaponEntity
import com.example.genshin_wiki.database.repositories.IWeaponLocalRepository

class WeaponLocalRepository : IWeaponLocalRepository {
    override suspend fun addWeapons(weapons: List<WeaponEntity>) {
        MainActivity.getWeaponDao()?.softInsertWeapons(weapons)
    }

    override suspend fun updateWeapon(weapon: WeaponEntity) {
        MainActivity.getWeaponDao()?.update(weapon)
    }

    override suspend fun getWeapons(): List<WeaponEntity>? {
        return MainActivity.getWeaponDao()?.getAllWeapons()
    }

    override suspend fun getLikedWeapons(): List<WeaponEntity>? {
        return MainActivity.getWeaponDao()?.getLikedWeapons()
    }

    override suspend fun getWeapon(id: String): WeaponEntity? {
        return MainActivity.getWeaponDao()?.getWeaponById(id)
    }
}