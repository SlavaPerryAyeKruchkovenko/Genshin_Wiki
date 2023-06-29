package com.example.genshin_wiki.domain.interfaces

interface IDislikeAllObjectsUseCase {
    suspend operator fun invoke(): Boolean
}