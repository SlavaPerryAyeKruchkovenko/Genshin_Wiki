package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.domain.interfaces.IGetAllCharactersUseCase
import com.example.genshin_wiki.repository.character.CharacterRepository

class GetAllCharactersUseCase: IGetAllCharactersUseCase {
    override suspend fun invoke(): List<CharacterConvert> {
        val repository = CharacterRepository()
        return repository.getAllCharacters()
    }
}