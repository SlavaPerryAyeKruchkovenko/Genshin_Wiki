package com.example.genshin_wiki.ui.weapon_portrait

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genshin_wiki.data.models.Weapon
import com.example.genshin_wiki.networks.Mock

class WeaponPortraitViewModel : ViewModel() {
    val liveData = MutableLiveData<Weapon?>()
    val isLiked = MutableLiveData<Boolean>()
    fun init(artifactId: String) {
        val mock = Mock()
        val weapon = mock.getWeaponById(artifactId)
        if (weapon != null) {
            liveData.postValue(weapon)
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