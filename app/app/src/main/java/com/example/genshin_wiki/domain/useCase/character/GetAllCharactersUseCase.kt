package com.example.genshin_wiki.domain.useCase.character

import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.domain.interfaces.character.IGetAllCharactersUseCase
import com.example.genshin_wiki.repository.character.CharacterRepository

class GetAllCharactersUseCase(private val repository: CharacterRepository): IGetAllCharactersUseCase {
    override suspend fun invoke(): List<CharacterConvert> {
        return repository.getAllCharacters()
    }
}