package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.domain.interfaces.IDislikeAllObjectsUseCase
import com.example.genshin_wiki.domain.interfaces.artifact.IDislikeAllArtifactsUseCase
import com.example.genshin_wiki.domain.interfaces.character.IDislikeAllCharactersUseCase
import com.example.genshin_wiki.domain.interfaces.weapon.IDislikeAllWeaponsUseCase

class DislikeAllObjectsUseCase(
    private val dislikeWeapons: IDislikeAllWeaponsUseCase,
    private val dislikeArtifacts: IDislikeAllArtifactsUseCase,
    private val dislikeCharacters: IDislikeAllCharactersUseCase,
) : IDislikeAllObjectsUseCase {
    override suspend fun invoke(): Boolean {
        return dislikeWeapons() && dislikeArtifacts() && dislikeCharacters()
    }
}