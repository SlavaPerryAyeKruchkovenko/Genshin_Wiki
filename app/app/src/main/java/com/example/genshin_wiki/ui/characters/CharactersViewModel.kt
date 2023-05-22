package com.example.genshin_wiki.ui.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.models.CharacterProfile
import com.example.genshin_wiki.repository.Mock

class CharactersViewModel : ViewModel(){
    val liveData = MutableLiveData<List<CharacterProfile>>()
    fun init(){
        val result = Mock().getCharacters()
        liveData.postValue(result)
    }
}