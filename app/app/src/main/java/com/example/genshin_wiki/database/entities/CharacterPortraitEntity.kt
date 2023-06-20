package com.example.genshin_wiki.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterPortraitEntity (
    @ColumnInfo(name = "portrait_id") @PrimaryKey val id: String,
    @ColumnInfo(name = "portrait_image")val image: String,
    val location: String,
    val sex: Boolean,
    val birthday: String,
    @ColumnInfo(name = "portrait_description")val description: String,
    val normalAttack: String,
    val elementalSkill: String,
    val elementalBurst: String,
)