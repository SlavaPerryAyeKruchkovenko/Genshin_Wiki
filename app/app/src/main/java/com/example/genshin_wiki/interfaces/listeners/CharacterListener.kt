package com.example.genshin_wiki.interfaces.listeners

import com.example.genshin_wiki.data.models.Character

interface CharacterListener {
    fun onClick(profile: Character)
}