package com.example.genshin_wiki.repository.character

import com.example.genshin_wiki.data.responses.CharacterDataResponse
import com.example.genshin_wiki.data.responses.CharacterListResponse
import com.example.genshin_wiki.data.responses.CharacterResponse
import com.example.genshin_wiki.networks.ArtifactApi
import com.example.genshin_wiki.networks.CharacterApi
import com.example.genshin_wiki.networks.repositories.ICharacterNetworkRepository
import com.example.genshin_wiki.networks.RetrofitBuilder
import retrofit2.Response

class CharacterNetworkRepository(private val api: CharacterApi): ICharacterNetworkRepository {
    override suspend fun getCharacters(): Response<CharacterListResponse> {
        return api.getCharacters()
    }

    override suspend fun getCharacter(id: String): Response<CharacterDataResponse> {
        return api.getCharacter(id)
    }
}