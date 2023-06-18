package com.example.genshin_wiki.data.requests

import com.google.gson.annotations.SerializedName

data class CharacterRequest(
    @SerializedName("_id") val id: String,
    @SerializedName("character_id") val portrait: CharacterPortraitRequest,
    @SerializedName("image") val image: String,
    @SerializedName("name") val name: String,
    @SerializedName("countOfStars") val stars: Number,
    @SerializedName("weaponType") val weaponType: WeaponTypeRequest,
    @SerializedName("element") val element: ElementRequest
)
