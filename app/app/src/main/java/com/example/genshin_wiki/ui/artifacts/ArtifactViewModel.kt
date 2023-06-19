package com.example.genshin_wiki.ui.artifacts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.models.Artifact
import com.example.genshin_wiki.domain.useCase.artifact.GetAllArtifactsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtifactViewModel : ViewModel() {
    val liveData = MutableLiveData<List<Artifact>>()

    fun init() {
        viewModelScope.launch {
            val artifacts = withContext(Dispatchers.IO) {
                val useCase = GetAllArtifactsUseCase()
                useCase()
            }
            liveData.postValue(artifacts.map { it.toArtifact() })
        }
    }
}