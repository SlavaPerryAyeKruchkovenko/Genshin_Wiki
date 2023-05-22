package com.example.genshin_wiki.models

abstract class Profile(id:String) {
    val id: String;
    init {
        this.id = id
    }
}