package com.example.genshin_wiki.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.models.DungeonResource
import com.example.genshin_wiki.repository.Mock

class HomeViewModel : ViewModel() {
    val liveData = MutableLiveData<List<DungeonResource>>()
    val pitchData = MutableLiveData<Int>()
    val adapterPositionData = MutableLiveData<Int>()
    fun init() {
        val resources = Mock().getResources()
        liveData.postValue(resources)
        pitchData.postValue(153)
        adapterPositionData.postValue(0)
    }

    fun resetPitch() {
        pitchData.postValue(0)
    }

    fun changeAdapterPosition(position: Int) {
        if (position in 0..3) {
            if(position != adapterPositionData.value){
                adapterPositionData.postValue(position)
            }
        } else {
            throw IndexOutOfBoundsException("incorrect index $position of adapter")
        }
    }
}