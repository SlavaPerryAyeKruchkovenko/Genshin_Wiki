package com.example.genshin_wiki.domain.interfaces.pitch

interface IClearPitchValueUseCase {
    suspend operator fun invoke(): Int
}