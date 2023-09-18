package com.example.genshin_wiki.ui.artifacts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.models.Artifact
import com.example.genshin_wiki.data.models.OutputOf
import com.example.genshin_wiki.domain.useCase.artifact.GetAllArtifactsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtifactViewModel(
    private val getArtifacts: GetAllArtifactsUseCase,
) : ViewModel() {
    val liveData = MutableLiveData<OutputOf<List<Artifact>>>()
    private var liveDataCopy: List<Artifact> = listOf()
    fun init() {
        liveData.postValue(OutputOf.Loader())
        viewModelScope.launch {
            try {
                val artifacts = withContext(Dispatchers.IO) {
                    getArtifacts()
                }
                liveDataCopy = artifacts.map { it.toArtifact() }
                liveData.postValue(
                    if (liveDataCopy.isNotEmpty())
                        OutputOf.Success(liveDataCopy)
                    else
                        OutputOf.Error.NotFoundError()
                )
            } catch (e: Exception) {
                liveData.postValue(OutputOf.Failure(e.message ?: "Fatal error"))
            }
        }
    }

    fun filterArtifactsByName(query: String) {
        val result = liveDataCopy.filter { x -> x.name.lowercase().startsWith(query.lowercase()) }
        liveData.postValue(
            if (result.isNotEmpty())
                OutputOf.Success(result)
            else
                OutputOf.Error.NotFoundError()
        )
    }
}