package com.example.genshin_wiki.domain.useCase.weapon

import android.util.Log
import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.weapon.IGetAllWeaponsUseCase
import com.example.genshin_wiki.repository.weapon.WeaponRepository

class GetAllWeaponsUseCase(private val repository: WeaponRepository) : IGetAllWeaponsUseCase {
    override suspend fun invoke(): List<WeaponConverter> {
        return repository.getAllWeapons()
    }
}