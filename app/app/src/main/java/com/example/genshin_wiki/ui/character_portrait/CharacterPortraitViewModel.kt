package com.example.genshin_wiki.ui.character_portrait

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.models.CharacterPortrait
import com.example.genshin_wiki.repository.Mock

class CharacterPortraitViewModel : ViewModel() {
    val characterPortrait = MutableLiveData<CharacterPortrait>()

    fun init(characterId: String) {
        val mock = Mock()
        val portrait = mock.getCharacterPortraitById(characterId)
        if (portrait != null) {
            characterPortrait.postValue(portrait)
        }
    }
}