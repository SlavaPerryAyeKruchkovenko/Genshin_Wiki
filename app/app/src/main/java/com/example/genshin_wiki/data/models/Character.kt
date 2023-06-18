package com.example.genshin_wiki.data.models

data class Character(
    val id: String,
    val image: String,
    val name: String,
    val stars: Int,
    val weaponType: WeaponType,
    val element: Element,
    val portrait: CharacterPortrait
): Likeable(id)