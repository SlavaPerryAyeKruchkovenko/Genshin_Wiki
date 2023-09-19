package com.example.genshin_wiki.domain.useCase.weapon

import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.weapon.IGetAllWeaponsUseCase
import com.example.genshin_wiki.repository.interfaces.IWeaponRepository

class GetAllWeaponsUseCase(private val repository: IWeaponRepository) : IGetAllWeaponsUseCase {
    override suspend fun invoke(): List<WeaponConverter> {
        return repository.getAllWeapons()
    }
}