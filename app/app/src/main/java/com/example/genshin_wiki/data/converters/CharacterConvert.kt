package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.Character
import com.example.genshin_wiki.data.responses.CharacterResponse
import com.example.genshin_wiki.database.entities.CharacterEntity

data class CharacterConvert(
    override val id: String,
    override var isLiked: Boolean,
    val image: String,
    val name: String,
    val stars: Int,
    val weaponType: WeaponTypeConvert,
    val element: ElementConverter,
    val portrait: CharacterPortraitConvert
) : Convert(id, isLiked) {
    fun toCharacter(): Character {
        val character = Character(
            this.id,
            this.image,
            this.name,
            this.stars,
            this.weaponType.toWeaponType(),
            this.element.toElement(),
            this.portrait.toCharacterPortrait()
        )
        if (isLiked) {
            character.like()
        } else {
            character.dislike()
        }
        return character
    }

    fun toCharacterEntity(): CharacterEntity {
        val isLike = if (this.isLiked) {
            1
        } else {
            0
        }
        return CharacterEntity(
            this.id,
            isLike,
            this.image,
            this.name,
            this.stars,
            this.weaponType.toWeaponTypeEntity(),
            this.element.toElementEntity(),
            this.portrait.toCharacterPortraitEntity()
        )
    }

    companion object {
        fun default(): CharacterConvert {
            return CharacterConvert(
                "0", false, "", "no data", 5,
                WeaponTypeConvert.default(), ElementConverter.default(),
                CharacterPortraitConvert.default()
            )
        }

        fun fromCharacterEntity(entity: CharacterEntity): CharacterConvert {
            val weaponTypes = WeaponTypeConvert.fromWeaponTypeEntity(entity.weaponType)
            val element = ElementConverter.fromElementEntity(entity.element)
            val portrait =
                CharacterPortraitConvert.fromCharacterPortraitEntity(entity.portrait)
            val isLike = entity.isLike > 0
            return CharacterConvert(
                entity.id, isLike, entity.image, entity.name,
                entity.stars, weaponTypes, element, portrait
            )
        }

        fun fromCharacterResponse(res: CharacterResponse): CharacterConvert {
            val weaponTypes = WeaponTypeConvert.fromWeaponTypeResponse(res.weaponType)
            val element = ElementConverter.fromElementResponse(res.element)
            val portrait =
                CharacterPortraitConvert.fromCharacterPortraitResponse(res.portrait)
            return CharacterConvert(
                res.id, false, res.image, res.name,
                res.stars, weaponTypes, element, portrait
            )
        }
    }
}