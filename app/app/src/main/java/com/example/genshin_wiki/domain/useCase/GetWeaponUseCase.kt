package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.IGetWeaponUseCase
import com.example.genshin_wiki.repository.weapon.WeaponRepository

class GetWeaponUseCase : IGetWeaponUseCase {
    override suspend fun invoke(id: String): WeaponConverter {
        val repository = WeaponRepository()
        return repository.getWeaponById(id)
    }
}