package com.example.genshin_wiki.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeaponTypeEntity(
    @ColumnInfo(name = "weapon_type_id")@PrimaryKey val id: String,
    @ColumnInfo(name = "weapon_type_name") val name: String,
    @ColumnInfo(name = "weapon_type_image") val image: String
)
