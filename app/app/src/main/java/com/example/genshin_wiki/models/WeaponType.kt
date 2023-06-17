package com.example.genshin_wiki.models

import com.example.genshin_wiki.models.enums.WeaponTypes

data class WeaponType(
    val id: String,
    val name: WeaponTypes,
    val image: String)