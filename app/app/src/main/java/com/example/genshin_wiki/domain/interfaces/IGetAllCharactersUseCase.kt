package com.example.genshin_wiki.domain.interfaces

import com.example.genshin_wiki.data.converters.CharacterConvert

interface IGetAllCharactersUseCase {
    suspend operator fun invoke(): List<CharacterConvert>
}