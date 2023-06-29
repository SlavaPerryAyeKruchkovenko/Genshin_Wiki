package com.example.genshin_wiki.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.models.DungeonResource
import com.example.genshin_wiki.data.models.enums.Day
import com.example.genshin_wiki.domain.helpers.ResourceDay
import com.example.genshin_wiki.domain.useCase.dungeon_resources.GetResourcesByDayUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    val liveData = MutableLiveData<List<DungeonResource>>()
    val pitchData = MutableLiveData<Int>()
    val adapterPositionData = MutableLiveData<Int>()
    val dayOfWeekData = MutableLiveData<Day>()
    fun init() {
        pitchData.postValue(153)
        adapterPositionData.postValue(0)
    }

    fun initDungeonResource(day: Day) {
        viewModelScope.launch {
            val resources = withContext(Dispatchers.IO) {
                val useCase = GetResourcesByDayUseCase()
                val resDay = ResourceDay.valueOf(day.name.substring(0, 3))
                useCase(resDay)
            }
            liveData.postValue(resources.map { it.toDungeonResource() })
        }
    }

    fun resetPitch() {
        pitchData.postValue(0)
    }

    fun changeAdapterPosition(position: Int) {
        if (position in 0..3) {
            if (position != adapterPositionData.value) {
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