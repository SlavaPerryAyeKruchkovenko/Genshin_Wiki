package com.example.genshin_wiki.di.modules

import com.example.genshin_wiki.di.modules.dataModules.localDataModule
import com.example.genshin_wiki.di.modules.dataModules.networkDataModule
import com.example.genshin_wiki.di.modules.dataModules.unitedDataModule
import com.example.genshin_wiki.di.modules.domainModules.*
import org.koin.core.module.Module

val appModules: List<Module> = listOf(
    retrofitModule,
    dataBaseModule,
    localDataModule,
    networkDataModule,
    unitedDataModule,
    artifactDomainModule,
    characterDomainModule,
    dungeonResourceDomainModule,
    pitchDomainModule,
    weaponDomainModule,
    likeDomainModule,
    viewModelsModule
)