package com.example.genshin_wiki.domain.useCase

import android.util.Log
import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.domain.interfaces.IGetAllWeaponsUseCase
import com.example.genshin_wiki.repository.weapon.WeaponRepository

class GetAllWeaponsUseCase : IGetAllWeaponsUseCase {
    override suspend fun invoke(): List<WeaponConverter> {
        val repository = WeaponRepository()
        Log.d("weapons",repository.getAllWeapons().toString())
        return repository.getAllWeapons()
    }
}