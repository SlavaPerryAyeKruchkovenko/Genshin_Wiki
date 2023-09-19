package com.example.genshin_wiki.domain.useCase.character

import com.example.genshin_wiki.domain.interfaces.character.IDislikeAllCharactersUseCase
import com.example.genshin_wiki.repository.interfaces.ICharacterRepository

class DislikeAllCharactersUseCase(private val repository: ICharacterRepository) :
    IDislikeAllCharactersUseCase {
    override suspend fun invoke(): Boolean {
        return repository.dislikeCharacters()
    }
}