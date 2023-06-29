package com.example.genshin_wiki.database.repositories

import com.example.genshin_wiki.database.entities.CharacterEntity

interface ICharacterLocalRepository {
    suspend fun addCharacters(characters: List<CharacterEntity>)
    suspend fun updateArtifact(character: CharacterEntity)
    suspend fun getCharacters(): List<CharacterEntity>?
    suspend fun getLikedCharacters(): List<CharacterEntity>?
    suspend fun getCharacter(id: String): CharacterEntity?
    suspend fun dislikeCharacters()
}