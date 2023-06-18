package com.example.genshin_wiki.data.models

import com.example.genshin_wiki.data.models.enums.Elements

data class Element(
    val id: String,
    val name: Elements,
    val image: String)