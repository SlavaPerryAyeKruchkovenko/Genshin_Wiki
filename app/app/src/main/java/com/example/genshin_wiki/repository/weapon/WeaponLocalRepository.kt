package com.example.genshin_wiki.repository.weapon

import android.util.Log
import com.example.genshin_wiki.MainActivity
import com.example.genshin_wiki.database.entities.WeaponEntity
import com.example.genshin_wiki.database.repositories.IWeaponLocalRepository

class WeaponLocalRepository : IWeaponLocalRepository {
    override suspend fun addWeapons(weapons: List<WeaponEntity>) {
        Log.d("database",MainActivity.getWeaponDao().toString())
        MainActivity.getWeaponDao()?.softInsert(weapons)
    }

    override suspend fun updateWeapon(weapon: WeaponEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getWeapons(): List<WeaponEntity>? {
        return MainActivity.getWeaponDao()?.getAll()
    }

    override suspend fun getWeapon(id: String): WeaponEntity? {
        TODO("Not yet implemented")
    }
}