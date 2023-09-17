package com.example.genshin_wiki.di.modules.dataModules

import com.example.genshin_wiki.networks.repositories.IArtifactNetworkRepository
import com.example.genshin_wiki.networks.repositories.ICharacterNetworkRepository
import com.example.genshin_wiki.networks.repositories.IDungeonResourceNetworkRepository
import com.example.genshin_wiki.networks.repositories.IWeaponNetworkRepository
import com.example.genshin_wiki.repository.artifact.ArtifactNetworkRepository
import com.example.genshin_wiki.repository.character.CharacterNetworkRepository
import com.example.genshin_wiki.repository.dungeon_resource.DungeonResourceNetworkRepository
import com.example.genshin_wiki.repository.weapon.WeaponNetworkRepository
import org.koin.dsl.module

val networkDataModule = module {
    single<IArtifactNetworkRepository> {
        ArtifactNetworkRepository(api = get())
    }
    single<ICharacterNetworkRepository> {
        CharacterNetworkRepository(api = get())
    }
    single<IDungeonResourceNetworkRepository> {
        DungeonResourceNetworkRepository(api = get())
    }
    single<IWeaponNetworkRepository> {
        WeaponNetworkRepository(api = get())
    }
}