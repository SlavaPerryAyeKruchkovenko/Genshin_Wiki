package com.example.genshin_wiki.data.models

open class Likeable(val liked_id:String,isLiked: Boolean = false) {
    var isLike = isLiked
        private set

    fun dislike() {
        isLike = false
    }

    fun like() {
        isLike = true
    }
}