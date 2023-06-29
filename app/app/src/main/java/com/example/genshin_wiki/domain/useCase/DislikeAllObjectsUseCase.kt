package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.domain.interfaces.IDislikeAllObjectsUseCase
import com.example.genshin_wiki.domain.useCase.artifact.DislikeAllArtifactsUseCase
import com.example.genshin_wiki.domain.useCase.character.DislikeAllCharactersUseCase
import com.example.genshin_wiki.domain.useCase.weapon.DislikeAllWeaponsUseCase

class DislikeAllObjectsUseCase : IDislikeAllObjectsUseCase {
    override suspend fun invoke(): Boolean {
        val weaponsUseCase = DislikeAllWeaponsUseCase()
        val artifactUseCase = DislikeAllArtifactsUseCase()
        val characterUseCase = DislikeAllCharactersUseCase()
        return weaponsUseCase() && artifactUseCase() && characterUseCase()
    }
}