package com.example.genshin_wiki.ui.liked_profiles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.models.Likeable

class LikedProfilesViewModel : ViewModel() {
    val liveData = MutableLiveData<List<Likeable>>()
    fun init() {

    }
}