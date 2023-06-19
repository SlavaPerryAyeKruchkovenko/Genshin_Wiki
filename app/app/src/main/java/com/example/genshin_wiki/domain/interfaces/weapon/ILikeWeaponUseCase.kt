package com.example.genshin_wiki.domain.interfaces.weapon

import com.example.genshin_wiki.data.converters.WeaponConverter

interface ILikeWeaponUseCase {
    suspend operator fun invoke(weapon: WeaponConverter): WeaponConverter
}