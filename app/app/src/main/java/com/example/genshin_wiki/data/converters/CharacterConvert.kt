package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.Character
import com.example.genshin_wiki.data.responses.CharacterResponse

data class CharacterConvert(
    val id: String,
    val isLike: Boolean,
    val image: String,
    val name: String,
    val stars: Int,
    val weaponType: WeaponTypeConvert,
    val element: ElementConverter,
    val portrait: CharacterPortraitConvert
) {
    fun toCharacter(): Character {
        return Character(
            this.id,
            this.image,
            this.name,
            this.stars,
            this.weaponType.toWeaponType(),
            this.element.toElement(),
            this.portrait.toCharacterPortrait()
        )
    }

    companion object {
        fun fromCharacterResponse(req: CharacterResponse): CharacterConvert {
            val weaponTypes = WeaponTypeConvert.fromWeaponTypeResponse(req.weaponType)
            val element = ElementConverter.fromElementResponse(req.element)
            val portrait =
                CharacterPortraitConvert.fromCharacterPortraitRequestResponse(req.portrait)
            return CharacterConvert(
                req.id, false, req.image, req.name,
                req.stars, weaponTypes, element, portrait
            )
        }
    }
}