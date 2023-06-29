package com.example.genshin_wiki.domain.useCase.weapon

import android.util.Log
import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.weapon.IGetAllWeaponsUseCase
import com.example.genshin_wiki.repository.weapon.WeaponRepository

class GetAllWeaponsUseCase : IGetAllWeaponsUseCase {
    override suspend fun invoke(): List<WeaponConverter> {
        val repository = WeaponRepository()
        return repository.getAllWeapons()
    }
}