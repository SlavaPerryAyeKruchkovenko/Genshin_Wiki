package com.example.genshin_wiki.domain.useCase

import com.example.genshin_wiki.data.converters.Convert
import com.example.genshin_wiki.domain.interfaces.IGetLikedObjectsUseCase
import com.example.genshin_wiki.domain.interfaces.artifact.IGetLikedArtifactsUseCase
import com.example.genshin_wiki.domain.interfaces.character.IGetLikedCharacterUseCase
import com.example.genshin_wiki.domain.interfaces.weapon.IGetLikedWeaponsUseCase

class GetLikedObjectsUseCase(
    private val likedWeapons: IGetLikedWeaponsUseCase,
    private val likedArtifacts: IGetLikedArtifactsUseCase,
    private val likedCharacters: IGetLikedCharacterUseCase,
) : IGetLikedObjectsUseCase {
    override suspend fun invoke(): List<Convert> {
        return likedWeapons() + likedArtifacts() + likedCharacters()
    }
}