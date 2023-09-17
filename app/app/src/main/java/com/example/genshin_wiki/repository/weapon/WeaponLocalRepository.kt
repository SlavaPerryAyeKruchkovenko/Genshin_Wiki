package com.example.genshin_wiki.repository.weapon

import com.example.genshin_wiki.database.dao.WeaponDao
import com.example.genshin_wiki.database.entities.WeaponEntity
import com.example.genshin_wiki.database.repositories.IWeaponLocalRepository

class WeaponLocalRepository(private val dao: WeaponDao) : IWeaponLocalRepository {
    override suspend fun addWeapons(weapons: List<WeaponEntity>) {
        dao.softInsertWeapons(weapons)
    }

    override suspend fun updateWeapon(weapon: WeaponEntity) {
        dao.update(weapon)
    }

    override suspend fun getWeapons(): List<WeaponEntity> {
        return dao.getAllWeapons()
    }

    override suspend fun getLikedWeapons(): List<WeaponEntity> {
        return dao.getLikedWeapons()
    }

    override suspend fun getWeapon(id: String): WeaponEntity? {
        return dao.getWeaponById(id)
    }

    override suspend fun dislikeWeapons() {
        dao.dislikeAllWeapons()
    }
}