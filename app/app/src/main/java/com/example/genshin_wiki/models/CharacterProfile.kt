package com.example.genshin_wiki.models

data class CharacterProfile(
    val id: String,
    val characterId: String,
    val image: String,
    val name: String,
    val stars: Int,
    val weaponType: WeaponType,
    val element: Element
): Likeable(id)