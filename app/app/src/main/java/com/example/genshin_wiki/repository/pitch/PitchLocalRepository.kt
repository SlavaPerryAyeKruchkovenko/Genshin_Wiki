package com.example.genshin_wiki.repository.pitch

import android.content.SharedPreferences
import android.util.Log
import com.example.genshin_wiki.GenshinWikiApp
import com.example.genshin_wiki.MainActivity
import com.example.genshin_wiki.database.repositories.IPitchLocalRepository

class PitchLocalRepository() : IPitchLocalRepository {

    override suspend fun updatePitchValue(value: Int) {
        GenshinWikiApp.prefs?.edit()?.putInt(PITCH_PREF_NAME, value)?.apply()
    }

    override suspend fun getPitchValue(): Int {
        return GenshinWikiApp.prefs?.getInt(PITCH_PREF_NAME, 0) ?: 0
    }

    companion object {
        const val PITCH_PREF_NAME = "DATA_PREF"
    }
}