package com.example.genshin_wiki.data.requests

import com.google.gson.annotations.SerializedName

data class WeaponRequest(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("discription") val description: String,
    @SerializedName("type") val type: WeaponTypeRequest,
    @SerializedName("passiveAbility") val passiveAbility: String,
    @SerializedName("countOfStars") val stars: String,
    @SerializedName("editionStat") val editionStat: String,
    @SerializedName("image") val image: String,
    @SerializedName("stat") val stat: String,
)
