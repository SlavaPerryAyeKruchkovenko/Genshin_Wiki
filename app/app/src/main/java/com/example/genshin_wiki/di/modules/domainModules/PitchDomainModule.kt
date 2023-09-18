package com.example.genshin_wiki.di.modules.domainModules

import com.example.genshin_wiki.domain.interfaces.pitch.IClearPitchValueUseCase
import com.example.genshin_wiki.domain.interfaces.pitch.IGetPitchValueUseCase
import com.example.genshin_wiki.domain.interfaces.pitch.IUpdatePitchValueUseCase
import com.example.genshin_wiki.domain.useCase.pitch.ClearPitchValueUseCase
import com.example.genshin_wiki.domain.useCase.pitch.GetPitchValueUseCase
import com.example.genshin_wiki.domain.useCase.pitch.UpdatePitchValueUseCase
import org.koin.dsl.module

val pitchDomainModule = module {
    factory<IClearPitchValueUseCase> {
        ClearPitchValueUseCase(repository = get())
    }
    factory<IGetPitchValueUseCase> {
        GetPitchValueUseCase(repository = get())
    }
    factory<IUpdatePitchValueUseCase> {
        UpdatePitchValueUseCase(repository = get())
    }
}