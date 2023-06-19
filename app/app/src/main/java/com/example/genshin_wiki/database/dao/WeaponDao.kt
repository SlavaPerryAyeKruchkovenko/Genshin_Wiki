package com.example.genshin_wiki.database.dao

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.genshin_wiki.database.entities.WeaponEntity

@Dao
interface WeaponDao {
    @Query("Select * from WeaponEntity")
    suspend fun getAll(): List<WeaponEntity>

    @Transaction
    suspend fun softInsert(weapons: List<WeaponEntity>) {
        val dbWeapons = getAll()
        Log.d("weapons",dbWeapons.toString())
        weapons.forEach { weapon ->
            val dbWeapon = dbWeapons.find { it.id == weapon.id }
            weapon.isLike = dbWeapon?.isLike ?: 0
        }
        deleteAll()
        insertTools(weapons)
    }
    @Query("Delete from WeaponEntity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertTools(weapons: List<WeaponEntity>)
}