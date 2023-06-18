package com.example.genshin_wiki.interfaces.useCase

import com.example.genshin_wiki.data.convert_models.CharacterConvert

interface IGetAllCharacterUseCase {
    suspend operator fun invoke(): List<CharacterConvert>
}