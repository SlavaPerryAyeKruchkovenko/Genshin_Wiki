package com.example.genshin_wiki.interfaces.repositories

import com.example.genshin_wiki.data.convert_models.CharacterConvert

interface ICharacterRepository {
    suspend fun getAllCharacters(): List<CharacterConvert>
    suspend fun getCharacterById(id: String): CharacterConvert
}