package com.example.genshin_wiki.domain.interfaces

import com.example.genshin_wiki.data.converters.CharacterConvert

interface IGetCharacterUseCase {
    suspend operator fun invoke(id: String): CharacterConvert
}