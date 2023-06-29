package com.example.genshin_wiki.domain.useCase.character

import com.example.genshin_wiki.domain.interfaces.character.IDislikeAllCharactersUseCase
import com.example.genshin_wiki.repository.character.CharacterRepository

class DislikeAllCharactersUseCase: IDislikeAllCharactersUseCase {
    override suspend fun invoke(): Boolean {
        val repository = CharacterRepository()
        return repository.dislikeCharacters()
    }
}