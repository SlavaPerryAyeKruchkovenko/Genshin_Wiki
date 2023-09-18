package com.example.genshin_wiki.di.modules.domainModules

import com.example.genshin_wiki.domain.interfaces.weapon.*
import com.example.genshin_wiki.domain.useCase.weapon.*
import org.koin.dsl.module

val weaponDomainModule = module {
    factory<IDislikeAllWeaponsUseCase> {
        DislikeAllWeaponsUseCase(repository = get())
    }
    factory<IDislikeWeaponUseCase> {
        DislikeWeaponUseCase(repository = get())
    }
    factory<IGetAllWeaponsUseCase> {
        GetAllWeaponsUseCase(repository = get())
    }
    factory<IGetWeaponUseCase> {
        GetWeaponUseCase(repository = get())
    }
    factory<IGetLikedWeaponsUseCase> {
        GetLikedWeaponsUseCase(repository = get())
    }
    factory<ILikeWeaponUseCase> {
        LikeWeaponUseCase(repository = get())
    }
}