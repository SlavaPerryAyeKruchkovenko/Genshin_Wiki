package com.example.genshin_wiki.data.responses

import com.google.gson.annotations.SerializedName

data class WeaponResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("discription") val description: String,
    @SerializedName("type") val type: WeaponTypeResponse,
    @SerializedName("passiveAbility") val passiveAbility: String,
    @SerializedName("countOfStars") val stars: Int,
    @SerializedName("editionStat") val editionStat: String,
    @SerializedName("image") val image: String,
    @SerializedName("stat") val stat: String,
)
