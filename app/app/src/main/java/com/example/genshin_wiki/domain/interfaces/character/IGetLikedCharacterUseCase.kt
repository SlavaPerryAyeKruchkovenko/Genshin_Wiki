package com.example.genshin_wiki.domain.interfaces.character

import com.example.genshin_wiki.data.converters.CharacterConvert

interface IGetLikedCharacterUseCase {
    suspend operator fun invoke(): List<CharacterConvert>
}