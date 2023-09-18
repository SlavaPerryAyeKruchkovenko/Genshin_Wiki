package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.data.converters.Convert
import com.example.genshin_wiki.domain.interfaces.IGetLikedObjectsUseCase
import com.example.genshin_wiki.domain.useCase.artifact.GetLikedArtifactsUseCase
import com.example.genshin_wiki.domain.useCase.character.GetLikedCharactersUseCase
import com.example.genshin_wiki.domain.useCase.weapon.GetLikedWeaponsUseCase

class GetLikedObjectsUseCase(
    private val likedWeapons: GetLikedWeaponsUseCase,
    private val likedArtifacts: GetLikedArtifactsUseCase,
    private val likedCharacters: GetLikedCharactersUseCase,
) : IGetLikedObjectsUseCase {
    override suspend fun invoke(): List<Convert> {
        return likedWeapons() + likedArtifacts() + likedCharacters()
    }
}