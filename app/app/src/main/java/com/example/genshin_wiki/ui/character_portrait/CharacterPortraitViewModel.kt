package com.example.genshin_wiki.ui.character_portrait

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.converters.CharacterConvert
import com.example.genshin_wiki.data.models.Character
import com.example.genshin_wiki.domain.interfaces.character.IDislikeCharacterUseCase
import com.example.genshin_wiki.domain.interfaces.character.IGetCharacterUseCase
import com.example.genshin_wiki.domain.interfaces.character.ILikeCharacterUseCase
import com.example.genshin_wiki.domain.useCase.character.DislikeCharacterUseCase
import com.example.genshin_wiki.domain.useCase.character.GetCharacterUseCase
import com.example.genshin_wiki.domain.useCase.character.LikeCharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterPortraitViewModel(
    private val getCharacter: IGetCharacterUseCase,
    private val likeCharacter: ILikeCharacterUseCase,
    private val dislikeCharacter: IDislikeCharacterUseCase
) : ViewModel() {
    val characterPortrait = MutableLiveData<Character?>()
    val isLiked = MutableLiveData(false)
    fun init(characterId: String) {
        viewModelScope.launch {
            val characterConvert = withContext(Dispatchers.IO) {
                getCharacter(characterId)
            }
            val character = characterConvert.toCharacter()
            characterPortrait.postValue(character)
            isLiked.postValue(character.isLike)
        }
    }

    fun changeLike() {
        viewModelScope.launch {
            val character = characterPortrait.value
            if (character != null) {
                val characterConvert = withContext(Dispatchers.IO) {
                    if (character.isLike) {
                        dislikeCharacter(CharacterConvert.fromCharacter(character))
                    } else {
                        likeCharacter(CharacterConvert.fromCharacter(character))
                    }
                }
                val newCharacter = characterConvert.toCharacter()
                isLiked.postValue(newCharacter.isLike)
                characterPortrait.postValue(newCharacter)
            }
        }
    }
}