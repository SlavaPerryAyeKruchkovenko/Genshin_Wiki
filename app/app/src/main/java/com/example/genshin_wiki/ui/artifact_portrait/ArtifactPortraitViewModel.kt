package com.example.genshin_wiki.ui.artifact_portrait

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.data.models.Artifact
import com.example.genshin_wiki.domain.useCase.artifact.DislikeArtifactUseCase
import com.example.genshin_wiki.domain.useCase.artifact.GetArtifactUseCase
import com.example.genshin_wiki.domain.useCase.artifact.LikeArtifactUseCase
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
        viewModelScope.launch {
            val likeUseCase = LikeArtifactUseCase()
            val dislikeUseCase = DislikeArtifactUseCase()
            val artifact = artifactPortrait.value
            if (artifact != null) {
                val artifactConvert = withContext(Dispatchers.IO) {
                    if (artifact.isLike) {
                        dislikeUseCase(ArtifactConvert.fromArtifact(artifact))
                    } else {
                        likeUseCase(ArtifactConvert.fromArtifact(artifact))
                    }
                }
                val newArtifact = artifactConvert.toArtifact()
                isLiked.postValue(newArtifact.isLike)
                artifactPortrait.postValue(newArtifact)
            }
        }
    }
}