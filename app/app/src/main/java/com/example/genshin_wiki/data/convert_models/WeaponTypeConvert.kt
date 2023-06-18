package com.example.genshin_wiki.data.convert_models

import com.example.genshin_wiki.data.models.WeaponType
import com.example.genshin_wiki.data.models.enums.WeaponTypes
import com.example.genshin_wiki.data.response.WeaponTypeResponse

class WeaponTypeConvert(
    val id: String,
    val name: String,
    val image: String
) {
    fun toWeaponType(): WeaponType{
        return WeaponType(
            this.id,
            WeaponTypes.valueOf(this.name.toUpperCase()),
            this.image
        )
    }
    companion object {
        fun fromWeaponTypeRequestResponse(req: WeaponTypeResponse): WeaponTypeConvert {
            return WeaponTypeConvert(
                req.id, req.name, req.image
            )
        }
    }
}