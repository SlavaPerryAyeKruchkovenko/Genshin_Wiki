package com.example.genshin_wiki.domain.useCase.weapon

import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.weapon.ILikeWeaponUseCase
import com.example.genshin_wiki.repository.interfaces.IWeaponRepository

class LikeWeaponUseCase(private val repository: IWeaponRepository) : ILikeWeaponUseCase {
    override suspend fun invoke(weapon: WeaponConverter): WeaponConverter {
        weapon.isLiked = true
        return repository.updateWeapon(weapon)
    }
}