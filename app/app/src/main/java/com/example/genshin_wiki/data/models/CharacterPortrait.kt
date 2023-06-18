package com.example.genshin_wiki.data.models

data class CharacterPortrait(
    val id: String,
    val name: String,
    val image: String,
    val location: String,
    val sex: Boolean,
    val birthday: String,
    val description: String,
    val normalAttack: String,
    val elementalSkill: String,
    val elementalBurst: String,
)