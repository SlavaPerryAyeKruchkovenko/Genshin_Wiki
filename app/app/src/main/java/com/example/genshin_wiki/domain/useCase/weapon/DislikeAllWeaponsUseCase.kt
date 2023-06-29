package com.example.genshin_wiki.domain.useCase.weapon

import com.example.genshin_wiki.domain.interfaces.weapon.IDislikeAllWeaponsUseCase
import com.example.genshin_wiki.repository.weapon.WeaponRepository

class DislikeAllWeaponsUseCase: IDislikeAllWeaponsUseCase {
    override suspend fun invoke(): Boolean {
        val repository = WeaponRepository()
        return repository.dislikeWeapons()
    }
}