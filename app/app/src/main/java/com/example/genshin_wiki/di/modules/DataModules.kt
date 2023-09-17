package com.example.genshin_wiki.di.modules

import com.example.genshin_wiki.di.modules.dataModules.localDataModule
import com.example.genshin_wiki.di.modules.dataModules.networkDataModule
import com.example.genshin_wiki.di.modules.dataModules.unitedDataModule
import org.koin.core.module.Module

val dataModules: List<Module> = listOf(
    localDataModule,
    networkDataModule,
    unitedDataModule,
)