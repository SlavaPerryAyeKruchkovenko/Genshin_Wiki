package com.example.genshin_wiki.interfaces

import com.example.genshin_wiki.data.models.Weapon

interface WeaponListener {
    fun onClick(profile: Weapon)
}