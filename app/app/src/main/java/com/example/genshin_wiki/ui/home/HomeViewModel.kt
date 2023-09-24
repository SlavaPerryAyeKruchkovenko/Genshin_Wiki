package com.example.genshin_wiki.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.models.DungeonResource
import com.example.genshin_wiki.data.models.OutputOf
import com.example.genshin_wiki.data.models.enums.Day
import com.example.genshin_wiki.domain.helpers.ResourceDay
import com.example.genshin_wiki.domain.interfaces.dungeon_resource.IGetResourcesByDayUseCase
import com.example.genshin_wiki.domain.interfaces.pitch.IClearPitchValueUseCase
import com.example.genshin_wiki.domain.interfaces.pitch.IGetPitchValueUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getPitch: IGetPitchValueUseCase,
    private val clearPitch: IClearPitchValueUseCase,
    private val getResourcesByDay: IGetResourcesByDayUseCase
) : ViewModel() {
    val liveData = MutableLiveData<OutputOf<List<DungeonResource>>>()
    val pitchData = MutableLiveData<Int>()
    val adapterPositionData = MutableLiveData<Int>()
    val dayOfWeekData = MutableLiveData<Day>()
    fun init() {
        viewModelScope.launch {
            val pitchValue = withContext(Dispatchers.IO) {
                getPitch()
            }
            pitchData.postValue(pitchValue)
        }
        adapterPositionData.postValue(0)
    }

    fun initDungeonResource(day: Day) {
        liveData.postValue(OutputOf.Loader())
        viewModelScope.launch {
            try {
                val resources = withContext(Dispatchers.IO) {
                    val resDay = ResourceDay.valueOf(day.name.substring(0, 3))
                    getResourcesByDay(resDay)
                }
                val result = resources.map { it.toDungeonResource() }
                liveData.postValue(
                    if (result.isNotEmpty()) {
                        if (result.size == 1) {
                            OutputOf.Error.SundayError()
                        } else {
                            OutputOf.Success(result)
                        }
                    } else
                        OutputOf.Error.NotFoundError()
                )
            } catch (e: Exception) {
                liveData.postValue(OutputOf.Failure(e.message ?: "Fatal error"))
            }
        }
    }

    fun resetPitch() {
        viewModelScope.launch {
            val pitchValue = withContext(Dispatchers.IO) {
                clearPitch()
            }
            pitchData.postValue(pitchValue)
        }
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