package com.example.genshin_wiki.models

data class Artifact(
    val id: String,
    val image: String,
    val name: String,
    val stars: Int
): Likeable(id)