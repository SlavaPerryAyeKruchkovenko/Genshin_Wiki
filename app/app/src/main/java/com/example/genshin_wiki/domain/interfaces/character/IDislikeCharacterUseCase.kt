package com.example.genshin_wiki.domain.interfaces.character

import com.example.genshin_wiki.data.converters.CharacterConvert

interface IDislikeCharacterUseCase {
    suspend operator fun invoke(character: CharacterConvert): CharacterConvert
}