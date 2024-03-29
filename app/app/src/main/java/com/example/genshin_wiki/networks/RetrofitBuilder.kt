package com.example.genshin_wiki.networks

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val url = "https://genshin-wiki.onrender.com/"
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val artifactApi: ArtifactApi = getRetrofit().create(ArtifactApi::class.java)
    val characterApi: CharacterApi = getRetrofit().create(CharacterApi::class.java)
    val weaponApi: WeaponApi = getRetrofit().create(WeaponApi::class.java)
    val resourceApi: DungeonResourceApi = getRetrofit().create(DungeonResourceApi::class.java)
}