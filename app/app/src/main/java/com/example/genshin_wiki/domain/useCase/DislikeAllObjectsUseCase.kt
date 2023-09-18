package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.domain.interfaces.IDislikeAllObjectsUseCase
import com.example.genshin_wiki.domain.useCase.weapon.DislikeAllWeaponsUseCase

class DislikeAllObjectsUseCase(
    private val dislikeWeapons: DislikeAllWeaponsUseCase,
    private val dislikeArtifacts: DislikeAllWeaponsUseCase,
    private val dislikeCharacters: DislikeAllWeaponsUseCase,
) : IDislikeAllObjectsUseCase {
    override suspend fun invoke(): Boolean {
        return dislikeWeapons() && dislikeArtifacts() && dislikeCharacters()
    }
}