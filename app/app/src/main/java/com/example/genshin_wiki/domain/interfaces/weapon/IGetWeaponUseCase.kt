package com.example.genshin_wiki.domain.interfaces.weapon

import com.example.genshin_wiki.data.converters.WeaponConverter

interface IGetWeaponUseCase {
    suspend operator fun invoke(id: String): WeaponConverter
}