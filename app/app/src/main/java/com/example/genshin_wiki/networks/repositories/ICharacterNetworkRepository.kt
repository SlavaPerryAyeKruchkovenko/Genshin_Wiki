package com.example.genshin_wiki.networks.repositories

import com.example.genshin_wiki.data.responses.CharacterDataResponse
import com.example.genshin_wiki.data.responses.CharacterListResponse
import com.example.genshin_wiki.data.responses.CharacterResponse
import retrofit2.Response

interface ICharacterNetworkRepository {
    suspend fun getCharacters(): Response<CharacterListResponse>
    suspend fun getCharacter(id:String): Response<CharacterDataResponse>
}