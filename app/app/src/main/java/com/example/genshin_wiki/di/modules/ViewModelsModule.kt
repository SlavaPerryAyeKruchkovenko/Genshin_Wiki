package com.example.genshin_wiki.di.modules

import com.example.genshin_wiki.ui.artifact_portrait.ArtifactPortraitViewModel
import com.example.genshin_wiki.ui.artifacts.ArtifactViewModel
import com.example.genshin_wiki.ui.character_portrait.CharacterPortraitViewModel
import com.example.genshin_wiki.ui.characters.CharactersViewModel
import com.example.genshin_wiki.ui.home.HomeViewModel
import com.example.genshin_wiki.ui.liked_profiles.LikedProfilesViewModel
import com.example.genshin_wiki.ui.weapon_portrait.WeaponPortraitViewModel
import com.example.genshin_wiki.ui.weapons.WeaponsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArtifactPortraitViewModel(get(), get(), get()) }
    viewModel { ArtifactViewModel(get()) }
    viewModel { CharacterPortraitViewModel(get(), get(), get()) }
    viewModel { CharactersViewModel(get()) }
    viewModel { HomeViewModel(get(), get(), get()) }
    viewModel { LikedProfilesViewModel(get(), get()) }
    viewModel { WeaponPortraitViewModel(get(), get(), get()) }
    viewModel { WeaponsViewModel(get()) }
}