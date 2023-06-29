package com.example.genshin_wiki.domain.useCase.pitch

import com.example.genshin_wiki.domain.interfaces.pitch.IClearPitchValueUseCase
import com.example.genshin_wiki.repository.pitch.PitchRepository

class ClearPitchValueUseCase: IClearPitchValueUseCase {
    override suspend fun invoke(): Int {
        val repository = PitchRepository()
        return repository.updatePitchValue(0)
    }
}