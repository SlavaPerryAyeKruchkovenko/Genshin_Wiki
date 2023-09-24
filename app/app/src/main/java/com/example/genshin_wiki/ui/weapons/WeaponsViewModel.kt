package com.example.genshin_wiki.ui.weapons

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.models.OutputOf
import com.example.genshin_wiki.data.models.Weapon
import com.example.genshin_wiki.domain.interfaces.weapon.IGetAllWeaponsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeaponsViewModel(
    private val getWeapons: IGetAllWeaponsUseCase,
) : ViewModel(){
    val liveData = MutableLiveData<OutputOf<List<Weapon>>>()
    private var liveDataCopy: List<Weapon> = listOf()
    fun init() {
        liveData.postValue(OutputOf.Loader())
        viewModelScope.launch {
            try {
                val weapons = withContext(Dispatchers.IO) {
                    getWeapons()
                }
                liveDataCopy = weapons.map { it.toWeapon() }
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

    fun filterWeaponsByName(query: String) {
        val result = liveDataCopy.filter { x -> x.name.lowercase().startsWith(query.lowercase()) }
        liveData.postValue(
            if (result.isNotEmpty())
                OutputOf.Success(result)
            else
                OutputOf.Error.NotFoundError()
        )
    }
}