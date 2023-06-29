package com.example.genshin_wiki.domain.useCase.pitch

import com.example.genshin_wiki.domain.interfaces.pitch.IUpdatePitchValueUseCase
import com.example.genshin_wiki.repository.pitch.PitchRepository

class UpdatePitchValueUseCase : IUpdatePitchValueUseCase {
    override suspend fun invoke(value: Int): Int {
        val repository = PitchRepository()
        return repository.updatePitchValue(value)
    }
}