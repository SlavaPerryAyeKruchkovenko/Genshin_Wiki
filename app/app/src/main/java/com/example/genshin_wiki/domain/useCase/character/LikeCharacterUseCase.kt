package com.example.genshin_wiki.domain.useCase.character

import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.domain.interfaces.character.ILikeCharacterUseCase
import com.example.genshin_wiki.repository.character.CharacterRepository

class LikeCharacterUseCase : ILikeCharacterUseCase {
    override suspend fun invoke(character: CharacterConvert): CharacterConvert {
        val repository = CharacterRepository()
        character.isLiked = true
        return repository.updateCharacter(character)
    }
}