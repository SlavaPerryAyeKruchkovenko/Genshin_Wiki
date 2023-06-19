package com.example.genshin_wiki.repository.character

import android.util.Log
import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.repository.interfaces.ICharacterRepository

class CharacterRepository : ICharacterRepository {
    override suspend fun getAllCharacters(): List<CharacterConvert> {
        return try {
            val networkRepository = CharacterNetworkRepository()
            val res = networkRepository.getCharacters()
            if (res.isSuccessful) {
                val response = res.body()!!
                val characters = response.characters
                characters.map {
                    CharacterConvert.fromCharacterResponse(it)
                }
            } else {
                listOf()
            }
        } catch (e: Exception) {
            Log.e("character api error", e.toString())
            listOf()
        }
    }

    override suspend fun getCharacterById(id: String): CharacterConvert {
        return try {
            val networkRepository = CharacterNetworkRepository()
            val res = networkRepository.getCharacter(id)
            if (res.isSuccessful) {
                val data = res.body()!!
                val character = data.character
                CharacterConvert.fromCharacterResponse(character)
            } else {
                CharacterConvert.default()
            }
        } catch (e: Exception) {
            Log.e("weapon by id api error", e.toString())
            CharacterConvert.default()
        }
    }
}