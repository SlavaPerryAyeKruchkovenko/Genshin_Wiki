package com.example.genshin_wiki.ui.artifact_portrait

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.data.models.Artifact
import com.example.genshin_wiki.domain.interfaces.artifact.IDislikeArtifactUseCase
import com.example.genshin_wiki.domain.interfaces.artifact.IGetArtifactUseCase
import com.example.genshin_wiki.domain.interfaces.artifact.ILikeArtifactUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtifactPortraitViewModel(
    private val getArtifact: IGetArtifactUseCase,
    private val likeArtifact: ILikeArtifactUseCase,
    private val dislikeArtifact: IDislikeArtifactUseCase
) : ViewModel() {
    val artifactPortrait = MutableLiveData<Artifact?>()
    val isLiked = MutableLiveData<Boolean>()
    fun init(artifactId: String) {
        viewModelScope.launch {
            val artifactConvert = withContext(Dispatchers.IO) {
                getArtifact(artifactId)
            }
            val artifact = artifactConvert.toArtifact()
            artifactPortrait.postValue(artifact)
            isLiked.postValue(artifact.isLike)
        }
    }

    fun changeLike() {
        viewModelScope.launch {
            val artifact = artifactPortrait.value
            if (artifact != null) {
                val artifactConvert = withContext(Dispatchers.IO) {
                    if (artifact.isLike) {
                        dislikeArtifact(ArtifactConvert.fromArtifact(artifact))
                    } else {
                        likeArtifact(ArtifactConvert.fromArtifact(artifact))
                    }
                }
                val newArtifact = artifactConvert.toArtifact()
                isLiked.postValue(newArtifact.isLike)
                artifactPortrait.postValue(newArtifact)
            }
        }
    }
}