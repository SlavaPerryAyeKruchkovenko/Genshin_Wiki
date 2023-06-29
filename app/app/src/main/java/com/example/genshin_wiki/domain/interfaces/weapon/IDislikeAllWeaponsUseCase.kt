package com.example.genshin_wiki.domain.interfaces.weapon

interface IDislikeAllWeaponsUseCase {
    suspend operator fun invoke(): Boolean
}