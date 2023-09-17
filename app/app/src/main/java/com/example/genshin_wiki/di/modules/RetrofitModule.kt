package com.example.genshin_wiki.di.modules

import com.example.genshin_wiki.networks.ArtifactApi
import com.example.genshin_wiki.networks.CharacterApi
import com.example.genshin_wiki.networks.DungeonResourceApi
import com.example.genshin_wiki.networks.WeaponApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val url = "https://genshin-wiki.onrender.com/"
val retrofitModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<ArtifactApi> { get<Retrofit>().create(ArtifactApi::class.java) }
    single<CharacterApi> { get<Retrofit>().create(CharacterApi::class.java) }
    single<WeaponApi> { get<Retrofit>().create(WeaponApi::class.java) }
    single<DungeonResourceApi> { get<Retrofit>().create(DungeonResourceApi::class.java) }
}