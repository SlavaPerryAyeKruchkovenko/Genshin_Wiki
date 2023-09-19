package com.example.genshin_wiki.domain.useCase.weapon

import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.weapon.IGetWeaponUseCase
import com.example.genshin_wiki.repository.interfaces.IWeaponRepository

class GetWeaponUseCase(private val repository: IWeaponRepository) : IGetWeaponUseCase {
    override suspend fun invoke(id: String): WeaponConverter {
        return repository.getWeaponById(id)
    }
}