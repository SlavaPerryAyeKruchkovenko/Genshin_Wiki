package com.example.genshin_wiki.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.data.models.DungeonResource
import com.example.genshin_wiki.data.models.enums.Day
import com.example.genshin_wiki.networks.Mock

class HomeViewModel : ViewModel() {
    val liveData = MutableLiveData<List<DungeonResource>>()
    val pitchData = MutableLiveData<Int>()
    val adapterPositionData = MutableLiveData<Int>()
    val dayOfWeekData = MutableLiveData<Day>()
    fun init() {
        pitchData.postValue(153)
        adapterPositionData.postValue(0)
    }
    fun initDungeonResource(){
        val resources = Mock().getResources()
        liveData.postValue(resources)
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

    fun setCurrentDay(day: Day){
        dayOfWeekData.postValue(day)
    }
}