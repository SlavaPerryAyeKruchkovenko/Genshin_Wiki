package com.example.genshin_wiki.data.models

data class Artifact(
    val id: String,
    val image: String,
    val name: String,
    val stars: Int,
    val bonus2: String,
    val bonus4: String
): Likeable(id)