package com.example.genshin_wiki.data.converters

sealed class Convert(
    open val id:String,
    open var isLiked: Boolean
)