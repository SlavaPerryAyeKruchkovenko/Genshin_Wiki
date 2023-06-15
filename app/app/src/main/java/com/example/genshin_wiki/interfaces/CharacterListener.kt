package com.example.genshin_wiki.interfaces

import com.example.genshin_wiki.models.CharacterProfile

interface CharacterListener {
    fun onClick(profile: CharacterProfile)
}