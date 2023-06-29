package com.example.genshin_wiki.repository.pitch

import com.example.genshin_wiki.repository.interfaces.IPitchRepository

class PitchRepository : IPitchRepository {
    override suspend fun updatePitchValue(value: Int): Int {
        val localRepository = PitchLocalRepository()
        if (value in 0..160) {
            localRepository.updatePitchValue(value)
        }
        return localRepository.getPitchValue()
    }

    override suspend fun getPitchValue(): Int {
        val localRepository = PitchLocalRepository()
        return localRepository.getPitchValue()
    }

}