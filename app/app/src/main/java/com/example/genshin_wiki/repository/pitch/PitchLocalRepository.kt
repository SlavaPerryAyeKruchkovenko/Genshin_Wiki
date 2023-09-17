package com.example.genshin_wiki.repository.pitch

import android.content.SharedPreferences
import android.util.Log
import com.example.genshin_wiki.MainActivity
import com.example.genshin_wiki.database.repositories.IPitchLocalRepository

class PitchLocalRepository(private val prefs: SharedPreferences) : IPitchLocalRepository {

    override suspend fun updatePitchValue(value: Int) {
        prefs.edit()?.putInt(PITCH_PREF_NAME, value)?.apply()
    }

    override suspend fun getPitchValue(): Int {
        return prefs.getInt(PITCH_PREF_NAME, 0)
    }

    companion object {
        const val PITCH_PREF_NAME = "DATA_PREF"
    }
}