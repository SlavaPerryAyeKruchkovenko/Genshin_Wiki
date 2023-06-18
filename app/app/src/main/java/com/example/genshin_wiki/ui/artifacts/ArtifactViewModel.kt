package com.example.genshin_wiki.ui.artifacts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.data.models.Artifact
import com.example.genshin_wiki.repository.Mock

class ArtifactViewModel : ViewModel() {
    val liveData = MutableLiveData<List<Artifact>>()

    fun init() {
        val result = Mock().getArtifacts()
        liveData.postValue(result)
    }
}