package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.data.convert_models.CharacterConvert
import com.example.genshin_wiki.interfaces.useCase.IGetAllCharacterUseCase
import com.example.genshin_wiki.repository.character.CharacterRepository

class GetAllCharactersUseCase: IGetAllCharacterUseCase {
    override suspend fun invoke(): List<CharacterConvert> {
        val repository = CharacterRepository()
        return repository.getAllCharacters()
    }
}