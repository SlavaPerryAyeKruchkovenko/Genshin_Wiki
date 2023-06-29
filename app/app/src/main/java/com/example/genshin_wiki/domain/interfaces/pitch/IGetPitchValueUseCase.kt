package com.example.genshin_wiki.domain.interfaces.pitch

interface IGetPitchValueUseCase {
    suspend operator fun invoke(): Int
}