package com.example.genshin_wiki.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ElementEntity(
    @ColumnInfo(name = "element_id")@PrimaryKey val id: String,
    @ColumnInfo(name = "element_name") val name: String,
    @ColumnInfo(name = "element_image") val image: String
)