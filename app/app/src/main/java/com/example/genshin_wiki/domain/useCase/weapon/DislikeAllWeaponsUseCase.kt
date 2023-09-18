package com.example.genshin_wiki.domain.useCase.weapon

import com.example.genshin_wiki.domain.interfaces.weapon.IDislikeAllWeaponsUseCase
import com.example.genshin_wiki.repository.character.CharacterRepository
import com.example.genshin_wiki.repository.weapon.WeaponRepository

class DislikeAllWeaponsUseCase(private val repository: WeaponRepository): IDislikeAllWeaponsUseCase {
    override suspend fun invoke(): Boolean {
        return repository.dislikeWeapons()
    }
}