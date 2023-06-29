package com.example.genshin_wiki.domain.interfaces.pitch

interface IUpdatePitchValueUseCase {
    suspend operator fun invoke(value: Int): Int
}