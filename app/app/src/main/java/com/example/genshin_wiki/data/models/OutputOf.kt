package com.example.genshin_wiki.data.models

sealed class OutputOf<out T> {
    data class Success<out R>(val value: R) : OutputOf<R>()
    data class Failure<out R>(
        val message: String?
    ) : OutputOf<R>()

    sealed class Error<out R>(val message: String) : OutputOf<R>(){
        class SundayError<out R> : Error<R>("not found")
        class NotFoundError<out R> : Error<R>("not found")
    }
    class Loader<out R> : OutputOf<R>()
}