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
    private var liveDataCopy: List<Artifact> = listOf()
    fun init() {
        viewModelScope.launch {
            val artifacts = withContext(Dispatchers.IO) {
                val useCase = GetAllArtifactsUseCase()
                useCase()
            }
            liveDataCopy = artifacts.map { it.toArtifact() }
            liveData.postValue(liveDataCopy)
        }
    }

    fun filterArtifactsByName(query: String) {
        liveData.postValue(liveDataCopy.filter
        { x -> x.name.lowercase().startsWith(query.lowercase()) })
    }
}