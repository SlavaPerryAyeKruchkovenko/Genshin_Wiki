package com.example.genshin_wiki.ui.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.data.models.Character
import com.example.genshin_wiki.repository.Mock

class CharactersViewModel : ViewModel(){
    val liveData = MutableLiveData<List<Character>>()
    fun init(){
        val result = Mock().getCharacters()
        liveData.postValue(result)
    }
}