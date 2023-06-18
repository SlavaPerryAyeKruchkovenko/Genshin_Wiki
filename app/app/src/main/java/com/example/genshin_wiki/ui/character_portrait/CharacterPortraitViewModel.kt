package com.example.genshin_wiki.ui.character_portrait

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.data.models.Character
import com.example.genshin_wiki.repository.Mock

class CharacterPortraitViewModel : ViewModel() {
    val characterPortrait = MutableLiveData<Character?>()
    val isLiked = MutableLiveData(false)
    fun init(characterId: String) {
        val mock = Mock()
        val portrait = mock.getCharacterPortraitById(characterId)
        if (portrait != null) {
            characterPortrait.postValue(portrait)
            isLiked.postValue(portrait.isLike)
        }
    }

    fun changeLike() {
        val like = isLiked.value
        if (like != null) {
            isLiked.postValue(!like)
        } else {
            isLiked.postValue(true)
        }
    }
}