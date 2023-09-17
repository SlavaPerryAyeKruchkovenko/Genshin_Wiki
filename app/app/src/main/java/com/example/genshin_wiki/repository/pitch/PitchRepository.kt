package com.example.genshin_wiki.repository.pitch

import com.example.genshin_wiki.database.repositories.IPitchLocalRepository
import com.example.genshin_wiki.repository.interfaces.IPitchRepository

class PitchRepository(private val local: IPitchLocalRepository) : IPitchRepository {
    override suspend fun updatePitchValue(value: Int): Int {
        if (value in 0..160) {
            local.updatePitchValue(value)
        }
        return local.getPitchValue()
    }

    override suspend fun getPitchValue(): Int {
        return local.getPitchValue()
    }

}