package com.example.genshin_wiki.ui.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.models.Character
import com.example.genshin_wiki.domain.useCase.character.GetAllCharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersViewModel : ViewModel(){
    val liveData = MutableLiveData<List<Character>>()
    private var liveDataCopy: List<Character> = listOf()
    fun init() {
        viewModelScope.launch {
            val characters = withContext(Dispatchers.IO) {
                val useCase = GetAllCharactersUseCase()
                useCase()
            }
            liveDataCopy = characters.map { it.toCharacter() }
            liveData.postValue(liveDataCopy)
        }
    }

    fun filterCharactersByName(query: String) {
        liveData.postValue(liveDataCopy.filter
        { x -> x.name.lowercase().startsWith(query.lowercase()) })
    }
}