package com.example.genshin_wiki.domain.useCase.character

import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.domain.interfaces.character.IGetCharacterUseCase
import com.example.genshin_wiki.repository.character.CharacterRepository

class GetCharacterUseCase : IGetCharacterUseCase {
    override suspend fun invoke(id: String): CharacterConvert {
        val repository = CharacterRepository()
        return repository.getCharacterById(id)
    }
}