package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.data.converters.Convert
import com.example.genshin_wiki.domain.interfaces.IGetLikedObjectsUseCase
import com.example.genshin_wiki.domain.useCase.weapon.GetLikedWeaponsUseCase

class GetLikedObjectsUseCase : IGetLikedObjectsUseCase {
    override suspend fun invoke(): List<Convert> {
        val weapons = GetLikedWeaponsUseCase()
        return weapons()
    }
}