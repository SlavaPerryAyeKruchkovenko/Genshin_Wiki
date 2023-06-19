package com.example.genshin_wiki.domain.useCase.weapon

import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.weapon.IGetWeaponUseCase
import com.example.genshin_wiki.repository.weapon.WeaponRepository

class GetWeaponUseCase : IGetWeaponUseCase {
    override suspend fun invoke(id: String): WeaponConverter {
        val repository = WeaponRepository()
        return repository.getWeaponById(id)
    }
}