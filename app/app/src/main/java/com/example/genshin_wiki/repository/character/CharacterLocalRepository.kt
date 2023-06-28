package com.example.genshin_wiki.repository.character

import com.example.genshin_wiki.MainActivity
import com.example.genshin_wiki.database.entities.CharacterEntity
import com.example.genshin_wiki.database.repositories.ICharacterLocalRepository

class CharacterLocalRepository : ICharacterLocalRepository {

    override suspend fun addCharacters(characters: List<CharacterEntity>) {
        MainActivity.getCharacterDao()?.softInsertCharacters(characters)
    }

    override suspend fun updateArtifact(character: CharacterEntity) {
        MainActivity.getCharacterDao()?.update(character)
    }

    override suspend fun getCharacters(): List<CharacterEntity>? {
        return MainActivity.getCharacterDao()?.getAllCharacters()
    }

    override suspend fun getLikedCharacters(): List<CharacterEntity>? {
        return MainActivity.getCharacterDao()?.getLikedCharacter()
    }

    override suspend fun getCharacter(id: String): CharacterEntity? {
        return MainActivity.getCharacterDao()?.getCharacterById(id)
    }
}