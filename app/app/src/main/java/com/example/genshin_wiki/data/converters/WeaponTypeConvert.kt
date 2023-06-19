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
        val type = try {
            WeaponTypes.valueOf(this.name.uppercase())
        } catch (_: Exception) {
            WeaponTypes.CLAYMOR
        }
        return WeaponType(
            this.id,
            type,
            this.image
        )
    }
    companion object {
        fun default(): WeaponTypeConvert {
            return WeaponTypeConvert("0", "CLAYMOR", "")
        }

        fun fromWeaponTypeResponse(req: WeaponTypeResponse): WeaponTypeConvert {
            return WeaponTypeConvert(
                req.id, req.name, req.image
            )
        }
    }
}