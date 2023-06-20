package com.example.genshin_wiki.ui.character_portrait

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.models.Character
import com.example.genshin_wiki.domain.useCase.character.GetCharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterPortraitViewModel : ViewModel() {
    val characterPortrait = MutableLiveData<Character?>()
    val isLiked = MutableLiveData(false)
    fun init(characterId: String) {
        viewModelScope.launch {
            val characterConvert = withContext(Dispatchers.IO) {
                val useCase = GetCharacterUseCase()
                useCase(characterId)
            }
            val character = characterConvert.toCharacter()
            characterPortrait.postValue(character)
            isLiked.postValue(character.isLike)
        }
    }

    fun changeLike() {
        viewModelScope.launch {
            val like = isLiked.value
            if (like != null) {
                isLiked.postValue(!like)
            } else {
                isLiked.postValue(true)
            }
        }

    }
}