package com.example.genshin_wiki.ui.weapon_portrait

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshin_wiki.data.converters.WeaponConverter
import com.example.genshin_wiki.data.models.Weapon
import com.example.genshin_wiki.domain.interfaces.weapon.IDislikeWeaponUseCase
import com.example.genshin_wiki.domain.interfaces.weapon.IGetWeaponUseCase
import com.example.genshin_wiki.domain.interfaces.weapon.ILikeWeaponUseCase
import com.example.genshin_wiki.domain.useCase.weapon.DislikeWeaponUseCase
import com.example.genshin_wiki.domain.useCase.weapon.GetWeaponUseCase
import com.example.genshin_wiki.domain.useCase.weapon.LikeWeaponUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeaponPortraitViewModel(
    private val getWeapon: IGetWeaponUseCase,
    private val likeWeapon: ILikeWeaponUseCase,
    private val dislikeWeapon: IDislikeWeaponUseCase,
) : ViewModel() {
    val weaponPortrait = MutableLiveData<Weapon?>()
    val isLiked = MutableLiveData<Boolean>()
    fun init(artifactId: String) {
        viewModelScope.launch {
            val weaponConverter = withContext(Dispatchers.IO) {
                getWeapon(artifactId)
            }
            val weapon = weaponConverter.toWeapon()
            weaponPortrait.postValue(weapon)
            isLiked.postValue(weapon.isLike)
        }
    }

    fun changeLike() {
        viewModelScope.launch {
            val weapon = weaponPortrait.value
            if (weapon != null) {
                val weaponConvert = withContext(Dispatchers.IO) {
                    if (weapon.isLike) {
                        dislikeWeapon(WeaponConverter.fromWeapon(weapon))
                    } else {
                        likeWeapon(WeaponConverter.fromWeapon(weapon))
                    }
                }
                val newWeapon = weaponConvert.toWeapon()
                isLiked.postValue(newWeapon.isLike)
                weaponPortrait.postValue(newWeapon)
            }
        }
    }
}