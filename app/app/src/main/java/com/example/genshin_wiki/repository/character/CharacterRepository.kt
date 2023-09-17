package com.example.genshin_wiki.repository.character

import android.util.Log
import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.database.repositories.ICharacterLocalRepository
import com.example.genshin_wiki.networks.repositories.ICharacterNetworkRepository
import com.example.genshin_wiki.repository.interfaces.ICharacterRepository

class CharacterRepository(
    private val local: ICharacterLocalRepository,
    private val network: ICharacterNetworkRepository
) : ICharacterRepository {
    override suspend fun getAllCharacters(): List<CharacterConvert> {
        return try {
            val res = network.getCharacters()
            if (res.isSuccessful) {
                val response = res.body()!!
                val resCharacters = response.characters
                val characters = resCharacters.map {
                    CharacterConvert.fromCharacterResponse(it)
                }
                val charactersEntity = characters.map {
                    it.toCharacterEntity()
                }
                local.addCharacters(charactersEntity)
                characters
            } else {
                local.getCharacters()?.map {
                    CharacterConvert.fromCharacterEntity(it)
                } ?: listOf()
            }
        } catch (e: Exception) {
            Log.e("get all characters error", e.toString())
            local.getCharacters()?.map {
                CharacterConvert.fromCharacterEntity(it)
            } ?: listOf()
        }
    }

    override suspend fun getCharacterById(id: String): CharacterConvert {
        return try {
            val characterEntity = local.getCharacter(id)
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
        return try {
            val characterEntity = local.getCharacter(character.id)
            if (characterEntity != null) {
                characterEntity.isLike = if (character.isLiked) {
                    1
                } else {
                    0
                }
                local.updateArtifact(characterEntity)
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
        return try {
            local.getLikedCharacters()?.map {
                CharacterConvert.fromCharacterEntity(it)
            } ?: listOf()
        } catch (e: Exception) {
            Log.e("liked characters error", e.toString())
            listOf()
        }
    }

    override suspend fun dislikeCharacters(): Boolean {
        return try {
            local.dislikeCharacters()
            true
        } catch (e: Exception){
            Log.e("dislike characters error", e.toString())
            false
        }
    }
}