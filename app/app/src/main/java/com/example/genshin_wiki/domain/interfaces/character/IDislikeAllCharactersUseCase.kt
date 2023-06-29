package com.example.genshin_wiki.domain.interfaces.character

interface IDislikeAllCharactersUseCase {
    suspend operator fun invoke(): Boolean
}