package com.example.genshin_wiki.ui.artifact_portrait

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.models.Artifact
import com.example.genshin_wiki.domain.useCase.GetArtifactUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtifactPortraitViewModel : ViewModel() {
    val artifactPortrait = MutableLiveData<Artifact?>()
    val isLiked = MutableLiveData<Boolean>()
    fun init(artifactId: String) {
        viewModelScope.launch {
            val artifactConvert = withContext(Dispatchers.IO) {
                val useCase = GetArtifactUseCase()
                useCase(artifactId)
            }
            val artifact = artifactConvert.toArtifact()
            artifactPortrait.postValue(artifact)
            isLiked.postValue(artifact.isLike)
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