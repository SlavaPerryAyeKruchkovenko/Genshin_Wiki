package com.example.genshin_wiki.repository.character

import com.example.genshin_wiki.data.responses.CharacterListResponse
import com.example.genshin_wiki.data.responses.CharacterResponse
import com.example.genshin_wiki.networks.repositories.ICharacterNetworkRepository
import com.example.genshin_wiki.networks.RetrofitBuilder
import retrofit2.Response

class CharacterNetworkRepository: ICharacterNetworkRepository {
    override suspend fun getCharacters(): Response<CharacterListResponse> {
        return RetrofitBuilder.characterApi.getCharacter()
    }

    override suspend fun getCharacter(id: String): Response<CharacterResponse> {
        TODO("Not yet implemented")
    }

}