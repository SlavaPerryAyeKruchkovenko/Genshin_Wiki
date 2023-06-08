package com.example.genshin_wiki.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.models.DungeonResource
import com.example.genshin_wiki.repository.Mock

class HomeViewModel : ViewModel() {
    val liveData = MutableLiveData<List<DungeonResource>>()

    fun init() {
        val resources = Mock().getResources()
        liveData.postValue(resources)
    }
}