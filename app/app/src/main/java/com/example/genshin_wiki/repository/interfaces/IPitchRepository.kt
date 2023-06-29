package com.example.genshin_wiki.repository.interfaces

interface IPitchRepository {
    suspend fun updatePitchValue(value: Int): Int
    suspend fun getPitchValue(): Int
}