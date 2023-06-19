package com.example.genshin_wiki.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DungeonResourceEntity(
    @PrimaryKey val id: String,
    val location: String,
    val city: String,
    val image: String
)
