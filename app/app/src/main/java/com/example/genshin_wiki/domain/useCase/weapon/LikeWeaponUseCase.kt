package com.example.genshin_wiki.domain.useCase.weapon

import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.weapon.ILikeWeaponUseCase
import com.example.genshin_wiki.repository.weapon.WeaponRepository

class LikeWeaponUseCase : ILikeWeaponUseCase {
    override suspend fun invoke(weapon: WeaponConverter): WeaponConverter {
        val repository = WeaponRepository()
        weapon.isLiked = true
        return repository.updateWeapon(weapon)
    }
}