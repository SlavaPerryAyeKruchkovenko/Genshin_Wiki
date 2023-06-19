package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.CharacterPortrait
import com.example.genshin_wiki.data.responses.CharacterPortraitResponse

data class CharacterPortraitConvert(
    val id: String,
    val image: String,
    val location: String,
    val sex: Boolean,
    val birthday: String,
    val description: String,
    val normalAttack: String,
    val elementalSkill: String,
    val elementalBurst: String,
) {
    fun toCharacterPortrait(): CharacterPortrait {
        return CharacterPortrait(
            this.id,
            this.image,
            this.location,
            this.sex,
            this.birthday,
            this.description,
            this.normalAttack,
            this.elementalSkill,
            this.elementalBurst
        )
    }
    companion object {
        fun fromCharacterPortraitRequestResponse(req: CharacterPortraitResponse): CharacterPortraitConvert {
            return CharacterPortraitConvert(
                req.id,
                req.image,
                req.location,
                req.sex,
                req.birthday,
                req.description,
                req.normalAttack?.description ?: "no data",
                req.elementalSkill?.description ?: "no data",
                req.elementalBurst?.description ?: "no data"
            )
        }
    }
}