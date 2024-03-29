package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.WeaponType
import com.example.genshin_wiki.data.models.enums.WeaponTypes
import com.example.genshin_wiki.data.responses.WeaponTypeResponse
import com.example.genshin_wiki.database.entities.WeaponTypeEntity

class WeaponTypeConvert(
    val id: String,
    val name: String,
    val image: String
) {
    fun toWeaponType(): WeaponType{
        val type = try {
            WeaponTypes.valueOf(this.name.uppercase())
        } catch (_: Exception) {
            WeaponTypes.NoData
        }
        return WeaponType(
            this.id,
            type,
            this.image
        )
    }
    fun toWeaponTypeEntity(): WeaponTypeEntity{
        return WeaponTypeEntity(this.id,this.name,this.image)
    }
    companion object {
        fun default(): WeaponTypeConvert {
            return WeaponTypeConvert("0", "NoData", "")
        }
        fun fromWeaponTypeEntity(entity: WeaponTypeEntity): WeaponTypeConvert {
            return WeaponTypeConvert(
                entity.id, entity.name, entity.image
            )
        }
        fun fromWeaponTypeResponse(req: WeaponTypeResponse): WeaponTypeConvert {
            return WeaponTypeConvert(
                req.id, req.name, req.image
            )
        }
        fun fromWeaponType(weaponType:WeaponType): WeaponTypeConvert{
            return WeaponTypeConvert(
                weaponType.id, weaponType.name.name, weaponType.image
            )
        }
    }
}