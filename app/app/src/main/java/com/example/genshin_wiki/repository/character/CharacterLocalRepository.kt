package com.example.genshin_wiki.repository.character

import com.example.genshin_wiki.database.dao.CharacterDao
import com.example.genshin_wiki.database.entities.CharacterEntity
import com.example.genshin_wiki.database.repositories.ICharacterLocalRepository

class CharacterLocalRepository(private val dao: CharacterDao) : ICharacterLocalRepository {

    override suspend fun addCharacters(characters: List<CharacterEntity>) {
        dao.softInsertCharacters(characters)
    }

    override suspend fun updateArtifact(character: CharacterEntity) {
        dao.update(character)
    }

    override suspend fun getCharacters(): List<CharacterEntity> {
        return dao.getAllCharacters()
    }

    override suspend fun getLikedCharacters(): List<CharacterEntity> {
        return dao.getLikedCharacter()
    }

    override suspend fun getCharacter(id: String): CharacterEntity? {
        return dao.getCharacterById(id)
    }

    override suspend fun dislikeCharacters() {
        dao.dislikeAllCharacters()
    }
}