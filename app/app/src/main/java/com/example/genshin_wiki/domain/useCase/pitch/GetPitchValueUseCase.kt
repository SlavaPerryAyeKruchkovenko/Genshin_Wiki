package com.example.genshin_wiki.domain.useCase.pitch

import com.example.genshin_wiki.domain.interfaces.pitch.IGetPitchValueUseCase
import com.example.genshin_wiki.repository.pitch.PitchRepository

class GetPitchValueUseCase(private val repository: PitchRepository): IGetPitchValueUseCase {
    override suspend fun invoke(): Int {
        return repository.getPitchValue()
    }
}