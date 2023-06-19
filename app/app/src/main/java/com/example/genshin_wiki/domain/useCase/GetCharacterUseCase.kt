package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.domain.interfaces.IGetCharacterUseCase
import com.example.genshin_wiki.repository.character.CharacterRepository

class GetCharacterUseCase : IGetCharacterUseCase {
    override suspend fun invoke(id: String): CharacterConvert {
        val repository = CharacterRepository()
        return repository.getCharacterById(id)
    }
}