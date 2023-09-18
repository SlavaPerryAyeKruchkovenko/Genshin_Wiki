package com.example.genshin_wiki.di.modules

import com.example.genshin_wiki.di.modules.domainModules.*
import org.koin.core.module.Module

val domainModule: List<Module> = listOf(
    artifactDomainModule,
    characterDomainModule,
    dungeonResourceDomainModule,
    pitchDomainModule,
    weaponDomainModule,
    likeDomainModule,
)