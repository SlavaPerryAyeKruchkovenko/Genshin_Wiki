package com.example.genshin_wiki.di.modules.dataModules

import com.example.genshin_wiki.database.repositories.*
import com.example.genshin_wiki.repository.artifact.ArtifactLocalRepository
import com.example.genshin_wiki.repository.character.CharacterLocalRepository
import com.example.genshin_wiki.repository.dungeon_resource.DungeonResourceLocalRepository
import com.example.genshin_wiki.repository.pitch.PitchLocalRepository
import com.example.genshin_wiki.repository.weapon.WeaponLocalRepository
import org.koin.dsl.module

val localDataModule = module {
    single<IArtifactLocalRepository> {
        ArtifactLocalRepository(dao = get())
    }
    single<ICharacterLocalRepository> {
        CharacterLocalRepository(dao = get())
    }
    single<IDungeonResourceLocalRepository> {
        DungeonResourceLocalRepository(dao = get())
    }
    single<IWeaponLocalRepository> {
        WeaponLocalRepository(dao = get())
    }
    single<IPitchLocalRepository> {
        PitchLocalRepository()
    }
}