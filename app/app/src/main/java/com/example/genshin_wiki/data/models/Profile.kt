package com.example.genshin_wiki.data.models

abstract class Profile(id:String) {
    val id: String;
    init {
        this.id = id
    }
}