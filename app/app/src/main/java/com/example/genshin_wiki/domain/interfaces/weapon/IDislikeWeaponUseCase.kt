package com.example.genshin_wiki.domain.interfaces.weapon

import com.example.genshin_wiki.data.converters.WeaponConverter

interface IDislikeWeaponUseCase {
    suspend operator fun invoke(weapon: WeaponConverter): WeaponConverter
}