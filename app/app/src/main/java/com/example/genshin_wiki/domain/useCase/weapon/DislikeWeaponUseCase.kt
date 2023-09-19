package com.example.genshin_wiki.domain.useCase.weapon

import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.weapon.IDislikeWeaponUseCase
import com.example.genshin_wiki.repository.interfaces.IWeaponRepository

class DislikeWeaponUseCase(private val repository: IWeaponRepository) : IDislikeWeaponUseCase {
    override suspend fun invoke(weapon: WeaponConverter): WeaponConverter {
        weapon.isLiked = false
        return repository.updateWeapon(weapon)
    }
}