package com.example.genshin_wiki.domain.interfaces.weapon

import com.example.genshin_wiki.data.converters.WeaponConverter

interface IGetAllWeaponsUseCase {
    suspend operator fun invoke(): List<WeaponConverter>
}