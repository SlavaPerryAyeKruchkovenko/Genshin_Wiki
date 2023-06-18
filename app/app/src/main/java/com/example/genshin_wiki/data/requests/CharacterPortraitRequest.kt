package com.example.genshin_wiki.data.requests

import com.google.gson.annotations.SerializedName

data class CharacterPortraitRequest(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("name") val image: String,
    @SerializedName("location") val location: String,
    @SerializedName("location") val sex: Boolean,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("description") val description: String,
    @SerializedName("handAbility") val normalAttack: AbilityRequest,
    @SerializedName("elementAbility") val elementalSkill: AbilityRequest,
    @SerializedName("burstAbility") val elementalBurst: AbilityRequest
)

