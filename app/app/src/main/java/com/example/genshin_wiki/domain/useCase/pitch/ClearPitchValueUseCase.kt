package com.example.genshin_wiki.domain.useCase.pitch

import com.example.genshin_wiki.domain.interfaces.pitch.IClearPitchValueUseCase
import com.example.genshin_wiki.repository.interfaces.IPitchRepository

class ClearPitchValueUseCase(private val repository: IPitchRepository) : IClearPitchValueUseCase {
    override suspend fun invoke(): Int {
        return repository.updatePitchValue(0)
    }
}