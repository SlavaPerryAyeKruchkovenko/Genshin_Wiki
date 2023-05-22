package com.example.genshin_wiki.models

import com.example.genshin_wiki.models.enums.Stats

data class Weapon(
    val id: String,
    val name: String,
    val description: String,
    val type: WeaponType,
    val passiveAbility: String,
    val stars: Int,
    val stat: Stats,
    val editionStat: Stats,
    val image: String
)