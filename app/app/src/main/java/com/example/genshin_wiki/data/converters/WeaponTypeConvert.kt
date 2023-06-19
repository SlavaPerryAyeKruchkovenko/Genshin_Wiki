package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.WeaponType
import com.example.genshin_wiki.data.models.enums.WeaponTypes
import com.example.genshin_wiki.data.responses.WeaponTypeResponse

class WeaponTypeConvert(
    val id: String,
    val name: String,
    val image: String
) {
    fun toWeaponType(): WeaponType{
        return WeaponType(
            this.id,
            WeaponTypes.valueOf(this.name.uppercase()),
            this.image
        )
    }
    companion object {
        fun fromWeaponTypeResponse(req: WeaponTypeResponse): WeaponTypeConvert {
            return WeaponTypeConvert(
                req.id, req.name, req.image
            )
        }
    }
}