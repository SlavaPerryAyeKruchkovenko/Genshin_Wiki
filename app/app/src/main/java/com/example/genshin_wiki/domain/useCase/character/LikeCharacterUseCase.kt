package com.example.genshin_wiki.domain.useCase.character

import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.domain.interfaces.character.ILikeCharacterUseCase
import com.example.genshin_wiki.repository.character.CharacterRepository

class LikeCharacterUseCase(private val repository: CharacterRepository) : ILikeCharacterUseCase {
    override suspend fun invoke(character: CharacterConvert): CharacterConvert {
        character.isLiked = true
        return repository.updateCharacter(character)
    }
}