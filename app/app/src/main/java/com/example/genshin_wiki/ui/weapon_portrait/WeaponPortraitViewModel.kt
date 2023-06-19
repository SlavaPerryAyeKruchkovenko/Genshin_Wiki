package com.example.genshin_wiki.ui.weapon_portrait

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.data.models.Weapon
import com.example.genshin_wiki.domain.useCase.weapon.DislikeWeaponUseCase
import com.example.genshin_wiki.domain.useCase.weapon.GetWeaponUseCase
import com.example.genshin_wiki.domain.useCase.weapon.LikeWeaponUseCase
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
        viewModelScope.launch {
            val likeUseCase = LikeWeaponUseCase()
            val dislikeUseCase = DislikeWeaponUseCase()
            val weapon = weaponPortrait.value
            if (weapon != null) {
                val weaponConvert = withContext(Dispatchers.IO) {
                    Log.d("isLike", weapon.isLike.toString())
                    if (weapon.isLike) {
                        dislikeUseCase(WeaponConverter.fromWeapon(weapon))
                    } else {
                        likeUseCase(WeaponConverter.fromWeapon(weapon))
                    }
                }
                val newWeapon = weaponConvert.toWeapon()
                Log.d("isLike", newWeapon.isLike.toString())
                isLiked.postValue(newWeapon.isLike)
                weaponPortrait.postValue(newWeapon)
            }
        }
    }
}