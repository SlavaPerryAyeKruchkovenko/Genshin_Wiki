package com.example.genshin_wiki.data.responses

import com.google.gson.annotations.SerializedName

data class WeaponsListResponse(
    @SerializedName("data") val weapons: List<WeaponResponse>
)