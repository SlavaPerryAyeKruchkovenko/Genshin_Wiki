package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.CharacterPortrait
import com.example.genshin_wiki.data.responses.CharacterPortraitResponse
import com.example.genshin_wiki.database.entities.CharacterPortraitEntity

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

    fun toCharacterPortraitEntity(): CharacterPortraitEntity {
        val sex = if (this.sex) {
            1
        } else {
            0
        }
        return CharacterPortraitEntity(
            this.id,
            this.image,
            this.location,
            sex,
            this.birthday,
            this.description,
            this.normalAttack,
            this.elementalSkill,
            this.elementalBurst
        )
    }

    companion object {
        fun default(): CharacterPortraitConvert {
            return CharacterPortraitConvert(
                "0", "", "no data", false,
                "no data", "no data", "no data",
                "no data", "no data"
            )
        }

        fun fromCharacterPortraitEntity(entity: CharacterPortraitEntity): CharacterPortraitConvert {
            val sex = entity.sex > 0
            return CharacterPortraitConvert(
                entity.id,
                entity.image,
                entity.location,
                sex,
                entity.birthday,
                entity.description,
                entity.normalAttack,
                entity.elementalSkill,
                entity.elementalBurst
            )
        }

        fun fromCharacterPortraitResponse(res: CharacterPortraitResponse): CharacterPortraitConvert {
            return CharacterPortraitConvert(
                res.id,
                res.image,
                res.location,
                res.sex,
                res.birthday,
                res.description,
                res.normalAttack?.description ?: "no data",
                res.elementalSkill?.description ?: "no data",
                res.elementalBurst?.description ?: "no data"
            )
        }
    }
}