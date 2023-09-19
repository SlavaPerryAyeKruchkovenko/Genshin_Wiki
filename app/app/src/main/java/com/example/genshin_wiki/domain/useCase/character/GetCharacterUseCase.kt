package com.example.genshin_wiki.domain.useCase.character

import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.domain.interfaces.character.IGetCharacterUseCase
import com.example.genshin_wiki.repository.interfaces.ICharacterRepository

class GetCharacterUseCase(private val repository: ICharacterRepository) : IGetCharacterUseCase {
    override suspend fun invoke(id: String): CharacterConvert {
        return repository.getCharacterById(id)
    }
}