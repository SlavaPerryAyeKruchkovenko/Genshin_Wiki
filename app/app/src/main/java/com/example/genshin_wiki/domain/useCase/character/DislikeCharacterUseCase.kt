package com.example.genshin_wiki.domain.useCase.character

import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.domain.interfaces.character.IDislikeCharacterUseCase
import com.example.genshin_wiki.repository.character.CharacterRepository

class DislikeCharacterUseCase(private val repository: CharacterRepository): IDislikeCharacterUseCase {
    override suspend fun invoke(character: CharacterConvert): CharacterConvert {
        character.isLiked = false
        return repository.updateCharacter(character)
    }
}