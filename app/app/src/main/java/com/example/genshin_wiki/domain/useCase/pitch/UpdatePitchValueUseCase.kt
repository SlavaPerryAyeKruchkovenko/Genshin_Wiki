package com.example.genshin_wiki.domain.useCase.pitch

import com.example.genshin_wiki.domain.interfaces.pitch.IUpdatePitchValueUseCase
import com.example.genshin_wiki.repository.interfaces.IPitchRepository

class UpdatePitchValueUseCase(private val repository: IPitchRepository) : IUpdatePitchValueUseCase {
    override suspend fun invoke(value: Int): Int {
        return repository.updatePitchValue(value)
    }
}