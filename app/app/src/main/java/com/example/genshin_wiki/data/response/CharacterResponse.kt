package com.example.genshin_wiki.data.response

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("character_id") val portrait: CharacterPortraitResponse,
    @SerializedName("image") val image: String,
    @SerializedName("name") val name: String,
    @SerializedName("countOfStars") val stars: Int,
    @SerializedName("weaponType") val weaponType: WeaponTypeResponse,
    @SerializedName("element") val element: ElementResponse
)
