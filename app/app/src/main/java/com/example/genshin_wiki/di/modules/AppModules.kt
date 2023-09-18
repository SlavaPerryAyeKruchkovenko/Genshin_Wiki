package com.example.genshin_wiki.di.modules

import org.koin.core.module.Module

val appModules: List<Module> = listOf(
    retrofitModule,
    dataBaseModule,
    viewModelsModule
) + dataModules + domainModule