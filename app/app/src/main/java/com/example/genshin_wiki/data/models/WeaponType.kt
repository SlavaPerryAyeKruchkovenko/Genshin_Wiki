package com.example.genshin_wiki.data.models

import com.example.genshin_wiki.data.models.enums.WeaponTypes

data class WeaponType(
    val id: String,
    val name: WeaponTypes,
    val image: String)