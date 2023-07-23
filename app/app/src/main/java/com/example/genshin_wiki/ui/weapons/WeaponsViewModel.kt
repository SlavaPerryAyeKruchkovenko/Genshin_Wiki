package com.example.genshin_wiki.ui.weapons

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.models.Weapon
import com.example.genshin_wiki.domain.useCase.weapon.GetAllWeaponsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeaponsViewModel: ViewModel(){
    val liveData = MutableLiveData<List<Weapon>>()
    private var liveDataCopy: List<Weapon> = listOf()
    fun init() {
        viewModelScope.launch {
            val weapons = withContext(Dispatchers.IO) {
                val useCase = GetAllWeaponsUseCase()
                useCase()
            }
            liveDataCopy = weapons.map { it.toWeapon() }
            liveData.postValue(liveDataCopy)
        }
    }

    fun filterWeaponsByName(query: String) {
        liveData.postValue(liveDataCopy.filter
        { x -> x.name.lowercase().startsWith(query.lowercase()) })
    }
}