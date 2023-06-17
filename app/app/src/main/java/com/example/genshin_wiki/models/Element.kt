package com.example.genshin_wiki.models

import com.example.genshin_wiki.models.enums.Elements

data class Element(
    val id: String,
    val name: Elements,
    val image: String)