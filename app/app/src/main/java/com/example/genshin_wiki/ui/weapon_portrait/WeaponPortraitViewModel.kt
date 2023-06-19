package com.example.genshin_wiki.ui.weapon_portrait

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.models.Weapon
import com.example.genshin_wiki.domain.useCase.GetCharacterUseCase
import com.example.genshin_wiki.domain.useCase.GetWeaponUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeaponPortraitViewModel : ViewModel() {
    val weaponPortrait = MutableLiveData<Weapon?>()
    val isLiked = MutableLiveData<Boolean>()
    fun init(artifactId: String) {
        viewModelScope.launch {
            val weaponConverter = withContext(Dispatchers.IO) {
                val useCase = GetWeaponUseCase()
                useCase(artifactId)
            }
            val weapon = weaponConverter.toWeapon()
            weaponPortrait.postValue(weapon)
            isLiked.postValue(weapon.isLike)
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