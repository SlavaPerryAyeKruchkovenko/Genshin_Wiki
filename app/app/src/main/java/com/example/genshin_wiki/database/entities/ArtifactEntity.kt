package com.example.genshin_wiki.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArtifactEntity(
    @PrimaryKey
    val id: String,
    var isLike: Int,
    val image: String,
    val name: String,
    val stars: Int,
    val bonus2: String,
    val bonus4: String
);
