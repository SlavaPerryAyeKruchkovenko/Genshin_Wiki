package com.example.genshin_wiki.ui.weapons

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.models.Weapon
import com.example.genshin_wiki.repository.Mock

class WeaponsViewModel: ViewModel(){
    val liveData = MutableLiveData<List<Weapon>>()
    fun init(){
        val result = Mock().getWeapons()
        liveData.postValue(result)
    }
}