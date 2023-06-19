package com.example.genshin_wiki.data.responses

import com.google.gson.annotations.SerializedName

data class CharacterPortraitResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("location") val location: String,
    @SerializedName("sex") val sex: Boolean,
    @SerializedName("image") val image: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("description") val description: String,
    @SerializedName("handAbility") val normalAttack: AbilityResponse?,
    @SerializedName("elementAbility") val elementalSkill: AbilityResponse?,
    @SerializedName("burstAbility") val elementalBurst: AbilityResponse?
)

