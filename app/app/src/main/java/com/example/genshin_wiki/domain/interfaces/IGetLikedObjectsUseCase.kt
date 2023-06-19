package com.example.genshin_wiki.domain.interfaces

import com.example.genshin_wiki.data.converters.Convert

interface IGetLikedObjectsUseCase {
    suspend operator fun invoke(): List<Convert>
}