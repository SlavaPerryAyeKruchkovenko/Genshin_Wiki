package com.example.genshin_wiki.ui.liked_profiles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.models.Likeable
import com.example.genshin_wiki.domain.useCase.DislikeAllObjectsUseCase
import com.example.genshin_wiki.domain.useCase.GetLikedObjectsUseCase
import com.example.genshin_wiki.domain.useCase.character.GetAllCharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LikedProfilesViewModel(
    private val getLiked: GetLikedObjectsUseCase,
    private val dislikeAll: DislikeAllObjectsUseCase,
) : ViewModel() {
    val liveData = MutableLiveData<List<Likeable>>()
    fun init() {
        viewModelScope.launch {
            val likes = withContext(Dispatchers.IO) {
                getLiked()
            }
            liveData.postValue(likes.map {
                it.toLikeable()
            })
        }
    }

    fun clearLiked() {
        viewModelScope.launch {
            val isClear = withContext(Dispatchers.IO) {
                dislikeAll()
            }
            if (isClear) {
                liveData.postValue(listOf())
            }
        }
    }
}