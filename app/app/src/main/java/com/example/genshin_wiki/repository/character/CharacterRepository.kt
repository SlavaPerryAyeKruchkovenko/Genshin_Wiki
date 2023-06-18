package com.example.genshin_wiki.repository.character

import android.util.Log
import com.example.genshin_wiki.data.convert_models.CharacterConvert
import com.example.genshin_wiki.interfaces.repositories.ICharacterRepository

class CharacterRepository : ICharacterRepository {
    override suspend fun getAllCharacters(): List<CharacterConvert> {
        return try {
            val networkRepository = CharacterNetworkRepository()
            val res = networkRepository.getCharacters()
            Log.d("res", res.toString())
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
            Log.e("er", e.toString())
            listOf()
        }
    }

    override suspend fun getCharacterById(id: String): CharacterConvert {
        TODO("Not yet implemented")
    }
}