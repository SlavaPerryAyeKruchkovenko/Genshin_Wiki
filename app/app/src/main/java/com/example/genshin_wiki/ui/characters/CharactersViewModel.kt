package com.example.genshin_wiki.ui.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.models.Character
import com.example.genshin_wiki.data.models.OutputOf
import com.example.genshin_wiki.domain.interfaces.character.IGetAllCharactersUseCase
import com.example.genshin_wiki.domain.useCase.artifact.DislikeArtifactUseCase
import com.example.genshin_wiki.domain.useCase.artifact.GetArtifactUseCase
import com.example.genshin_wiki.domain.useCase.artifact.LikeArtifactUseCase
import com.example.genshin_wiki.domain.useCase.character.GetAllCharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersViewModel(
    private val getCharacters: IGetAllCharactersUseCase,
) : ViewModel(){
    val liveData = MutableLiveData<OutputOf<List<Character>>>()
    private var liveDataCopy: List<Character> = listOf()
    fun init() {
        liveData.postValue(OutputOf.Loader())
        viewModelScope.launch {
            try {
                val characters = withContext(Dispatchers.IO) {
                    getCharacters()
                }
                liveDataCopy = characters.map { it.toCharacter() }
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

    fun filterCharactersByName(query: String) {
        val result = liveDataCopy.filter { x -> x.name.lowercase().startsWith(query.lowercase()) }
        liveData.postValue(
            if (result.isNotEmpty())
                OutputOf.Success(result)
            else
                OutputOf.Error.NotFoundError()
        )
    }
}