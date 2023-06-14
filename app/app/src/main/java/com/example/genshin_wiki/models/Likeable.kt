package com.example.genshin_wiki.models

open class Likeable(isLiked: Boolean = false) {
    var isLike = isLiked
        private set

    fun dislike() {
        isLike = false
    }

    fun like() {
        isLike = true
    }
}