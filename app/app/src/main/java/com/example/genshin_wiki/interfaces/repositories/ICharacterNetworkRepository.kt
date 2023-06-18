package com.example.genshin_wiki.interfaces.repositories

import com.example.genshin_wiki.data.response.CharacterListResponse
import com.example.genshin_wiki.data.response.CharacterResponse
import retrofit2.Response

interface ICharacterNetworkRepository {
    suspend fun getCharacters(): Response<CharacterListResponse>
    suspend fun getCharacter(id:String): Response<CharacterResponse>
}