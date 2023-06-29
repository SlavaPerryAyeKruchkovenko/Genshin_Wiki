package com.example.genshin_wiki.database.repositories

interface IPitchLocalRepository {
    suspend fun updatePitchValue(value: Int)
    suspend fun getPitchValue(): Int
}