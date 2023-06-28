package com.example.genshin_wiki.repository.character

import android.util.Log
import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.repository.interfaces.ICharacterRepository

class CharacterRepository : ICharacterRepository {
    override suspend fun getAllCharacters(): List<CharacterConvert> {
        val networkRepository = CharacterNetworkRepository()
        val localRepository = CharacterLocalRepository()
        return try {
            val res = networkRepository.getCharacters()
            if (res.isSuccessful) {
                val response = res.body()!!
                val resCharacters = response.characters
                val characters = resCharacters.map {
                    CharacterConvert.fromCharacterResponse(it)
                }
                val charactersEntity = characters.map {
                    it.toCharacterEntity()
                }
                localRepository.addCharacters(charactersEntity)
                characters
            } else {
                localRepository.getCharacters()?.map {
                    CharacterConvert.fromCharacterEntity(it)
                } ?: listOf()
            }
        } catch (e: Exception) {
            Log.e("get all characters error", e.toString())
            localRepository.getCharacters()?.map {
                CharacterConvert.fromCharacterEntity(it)
            } ?: listOf()
        }
    }

    override suspend fun getCharacterById(id: String): CharacterConvert {
        val localRepository = CharacterLocalRepository()
        return try {
            val characterEntity = localRepository.getCharacter(id)
            if (characterEntity != null) {
                CharacterConvert.fromCharacterEntity(characterEntity)
            } else {
                CharacterConvert.default()
            }
        } catch (e: Exception) {
            Log.e("get character by id error", e.toString())
            CharacterConvert.default()
        }
    }

    override suspend fun updateCharacter(character: CharacterConvert): CharacterConvert {
        val localRepository = CharacterLocalRepository()
        return try {
            val characterEntity = localRepository.getCharacter(character.id)
            if (characterEntity != null) {
                characterEntity.isLike = if (character.isLiked) {
                    1
                } else {
                    0
                }
                localRepository.updateArtifact(characterEntity)
                CharacterConvert.fromCharacterEntity(characterEntity)
            } else {
                CharacterConvert.default()
            }
        } catch (e: Exception) {
            Log.e("update character error", e.toString())
            CharacterConvert.default()
        }
    }

    override suspend fun getLikedCharacters(): List<CharacterConvert> {
        val localRepository = CharacterLocalRepository()
        return try {
            localRepository.getLikedCharacters()?.map {
                CharacterConvert.fromCharacterEntity(it)
            } ?: listOf()
        } catch (e: Exception) {
            Log.e("liked characters error", e.toString())
            listOf()
        }
    }
}