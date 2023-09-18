package com.example.genshin_wiki.domain.useCase.character

import com.example.genshin_wiki.domain.interfaces.character.IDislikeAllCharactersUseCase
import com.example.genshin_wiki.repository.artifact.ArtifactRepository
import com.example.genshin_wiki.repository.character.CharacterRepository

class DislikeAllCharactersUseCase(private val repository: CharacterRepository): IDislikeAllCharactersUseCase {
    override suspend fun invoke(): Boolean {
        return repository.dislikeCharacters()
    }
}