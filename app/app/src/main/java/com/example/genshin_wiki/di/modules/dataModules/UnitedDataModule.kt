package com.example.genshin_wiki.di.modules.dataModules

import com.example.genshin_wiki.repository.artifact.ArtifactRepository
import com.example.genshin_wiki.repository.character.CharacterRepository
import com.example.genshin_wiki.repository.dungeon_resource.DungeonResourceRepository
import com.example.genshin_wiki.repository.interfaces.*
import com.example.genshin_wiki.repository.pitch.PitchRepository
import com.example.genshin_wiki.repository.weapon.WeaponRepository
import org.koin.dsl.module

val unitedDataModule = module {
    single<IArtifactRepository> {
        ArtifactRepository(local = get(), network = get())
    }
    single<ICharacterRepository> {
        CharacterRepository(local = get(), network = get())
    }
    single<IDungeonResourceRepository> {
        DungeonResourceRepository(local = get(), network = get())
    }
    single<IWeaponRepository> {
        WeaponRepository(local = get(), network = get())
    }
    single<IPitchRepository> {
        PitchRepository(local = get())
    }
}