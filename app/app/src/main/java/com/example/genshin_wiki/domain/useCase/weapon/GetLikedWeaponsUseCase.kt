package com.example.genshin_wiki.domain.useCase.weapon

import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.weapon.IGetLikedWeaponsUseCase
import com.example.genshin_wiki.repository.weapon.WeaponRepository

class GetLikedWeaponsUseCase: IGetLikedWeaponsUseCase {
    override suspend fun invoke(): List<WeaponConverter> {
        val repository = WeaponRepository()
        return repository.getLikedWeapons()
    }
}