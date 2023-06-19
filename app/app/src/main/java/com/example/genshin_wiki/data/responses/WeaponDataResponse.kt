package com.example.genshin_wiki.data.responses

import com.google.gson.annotations.SerializedName

data class WeaponDataResponse(
    @SerializedName("data") val weapon: WeaponResponse
)