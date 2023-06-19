package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.IGetAllWeaponsUseCase
import com.example.genshin_wiki.repository.weapons.WeaponRepository

class GetAllWeaponsUseCase : IGetAllWeaponsUseCase {
    override suspend fun invoke(): List<WeaponConverter> {
        val repository = WeaponRepository()
        return repository.getAllWeapons()
    }
}