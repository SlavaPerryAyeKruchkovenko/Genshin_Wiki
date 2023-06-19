package com.example.genshin_wiki.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeaponEntity(
    @PrimaryKey val id: String,
    var isLike: Int,
    val name: String,
    val description: String,
    @Embedded val type: WeaponTypeEntity,
    val passiveAbility: String,
    val stars: Int,
    val stat: String,
    val editionStat: String,
    val image: String,
)
