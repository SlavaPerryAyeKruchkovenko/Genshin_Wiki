package com.example.genshin_wiki.models

data class Weapons(
    val id: String,
    val name: String,
    val description: String,
    val type: WeaponType,
    val passiveAbility: String,
    val stars: Int,
    val stat: String,
    val editionStat: String,
    val image: String
)