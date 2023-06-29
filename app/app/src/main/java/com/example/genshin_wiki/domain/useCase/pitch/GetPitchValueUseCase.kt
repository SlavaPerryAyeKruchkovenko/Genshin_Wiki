package com.example.genshin_wiki.domain.useCase.pitch

import com.example.genshin_wiki.domain.interfaces.pitch.IGetPitchValueUseCase
import com.example.genshin_wiki.repository.pitch.PitchRepository

class GetPitchValueUseCase: IGetPitchValueUseCase {
    override suspend fun invoke(): Int {
        val repository = PitchRepository()
        return repository.getPitchValue()
    }
}