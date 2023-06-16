package com.example.genshin_wiki.ui.liked_profiles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.models.Likeable
import com.example.genshin_wiki.repository.Mock

class LikedProfilesViewModel : ViewModel() {
    val liveData = MutableLiveData<List<Likeable>>()
    fun init() {
        val mock = Mock()
        liveData.postValue(mock.getLikeable())
    }

    fun clearLiked() {
        liveData.postValue(listOf())
    }
}