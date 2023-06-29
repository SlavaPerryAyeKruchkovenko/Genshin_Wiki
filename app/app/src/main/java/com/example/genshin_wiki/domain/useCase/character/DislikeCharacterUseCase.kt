package com.example.genshin_wiki.domain.useCase.character

import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.domain.interfaces.character.IDislikeCharacterUseCase
import com.example.genshin_wiki.repository.character.CharacterRepository

class DislikeCharacterUseCase: IDislikeCharacterUseCase {
    override suspend fun invoke(character: CharacterConvert): CharacterConvert {
        val repository = CharacterRepository()
        character.isLiked = false
        return repository.updateCharacter(character)
    }
}