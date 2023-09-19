package com.example.genshin_wiki.domain.useCase.weapon

import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.weapon.IGetLikedWeaponsUseCase
import com.example.genshin_wiki.repository.interfaces.IWeaponRepository

class GetLikedWeaponsUseCase(private val repository: IWeaponRepository) : IGetLikedWeaponsUseCase {
    override suspend fun invoke(): List<WeaponConverter> {
        return repository.getLikedWeapons()
    }
}