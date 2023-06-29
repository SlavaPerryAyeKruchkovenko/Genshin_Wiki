package com.example.genshin_wiki.repository.interfaces

import com.example.genshin_wiki.data.converters.CharacterConvert

interface ICharacterRepository {
    suspend fun getAllCharacters(): List<CharacterConvert>
    suspend fun getCharacterById(id: String): CharacterConvert
    suspend fun updateCharacter(character: CharacterConvert): CharacterConvert
    suspend fun getLikedCharacters(): List<CharacterConvert>
    suspend fun dislikeCharacters(): Boolean
}