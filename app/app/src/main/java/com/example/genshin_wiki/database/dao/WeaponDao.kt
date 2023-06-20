package com.example.genshin_wiki.database.dao

import androidx.room.*
import com.example.genshin_wiki.database.entities.WeaponEntity

@Dao
interface WeaponDao {
    @Query("Select * from WeaponEntity")
    suspend fun getAllWeapons(): List<WeaponEntity>

    @Query("SELECT * FROM WeaponEntity WHERE id = :id")
    suspend fun getWeaponById(id: String): WeaponEntity?

    @Query("SELECT * FROM WeaponEntity WHERE isLike = 1")
    suspend fun getLikedWeapons(): List<WeaponEntity>

    @Query("Delete from WeaponEntity")
    suspend fun deleteWeapons()

    @Transaction
    suspend fun softInsertWeapons(weapons: List<WeaponEntity>) {
        val dbWeapons = getAllWeapons()
        weapons.forEach { weapon ->
            val dbWeapon = dbWeapons.find { it.id == weapon.id }
            weapon.isLike = dbWeapon?.isLike ?: 0
        }
        deleteWeapons()
        insertWeapons(weapons)
    }

    @Update
    suspend fun update(weapon: WeaponEntity)

    @Insert
    suspend fun insertWeapons(weapons: List<WeaponEntity>)
}