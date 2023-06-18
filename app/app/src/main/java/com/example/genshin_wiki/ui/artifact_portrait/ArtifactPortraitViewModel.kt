package com.example.genshin_wiki.ui.artifact_portrait

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.models.Artifact
import com.example.genshin_wiki.repository.Mock

class ArtifactPortraitViewModel : ViewModel() {
    val liveData = MutableLiveData<Artifact?>()
    val isLiked = MutableLiveData<Boolean>()
    fun init(artifactId: String) {
        val mock = Mock()
        val artifact = mock.getArtifactById(artifactId)
        if (artifact != null) {
            liveData.postValue(artifact)
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