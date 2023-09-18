package com.example.genshin_wiki.domain.useCase.pitch

import com.example.genshin_wiki.domain.interfaces.pitch.IClearPitchValueUseCase
import com.example.genshin_wiki.repository.character.CharacterRepository
import com.example.genshin_wiki.repository.pitch.PitchRepository

class ClearPitchValueUseCase(private val repository: PitchRepository): IClearPitchValueUseCase {
    override suspend fun invoke(): Int {
        return repository.updatePitchValue(0)
    }
}