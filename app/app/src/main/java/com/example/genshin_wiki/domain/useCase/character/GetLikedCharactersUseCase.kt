package com.example.genshin_wiki.domain.useCase.character

import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.domain.interfaces.character.IGetLikedCharacterUseCase
import com.example.genshin_wiki.repository.interfaces.ICharacterRepository

class GetLikedCharactersUseCase(private val repository: ICharacterRepository) :
    IGetLikedCharacterUseCase {
    override suspend fun invoke(): List<CharacterConvert> {
        return repository.getLikedCharacters()
    }
}