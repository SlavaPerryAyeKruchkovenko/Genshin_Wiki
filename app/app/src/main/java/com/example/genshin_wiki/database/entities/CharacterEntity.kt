package com.example.genshin_wiki.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterEntity(
    @PrimaryKey val id: String,
    val isLike: Int,
    val image: String,
    val name: String,
    val stars: Int,
    @Embedded val weaponType: WeaponTypeEntity,
    @Embedded val element: ElementEntity,
    @Embedded val portrait: CharacterPortraitEntity
)