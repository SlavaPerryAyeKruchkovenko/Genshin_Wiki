package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.Weapon
import com.example.genshin_wiki.data.models.enums.Stats
import com.example.genshin_wiki.data.responses.WeaponResponse

data class WeaponConverter(
    val id: String,
    val isLike: Boolean,
    val name: String,
    val description: String,
    val type: WeaponTypeConvert,
    val passiveAbility: String,
    val stars: Int,
    val stat: String,
    val editionStat: String,
    val image: String,
) {
    fun toWeapon(): Weapon {
        return Weapon(
            this.id,
            this.name,
            this.description,
            this.type.toWeaponType(),
            this.passiveAbility,
            this.stars,
            Stats.valueOf(this.stat.uppercase()),
            Stats.valueOf(this.editionStat.uppercase()),
            this.image
        )
    }

    companion object {
        fun fromWeaponResponse(req: WeaponResponse): WeaponConverter {
            val type = WeaponTypeConvert.fromWeaponTypeResponse(req.type)
            return WeaponConverter(
                req.id, false, req.name, req.description, type, req.passiveAbility,
                req.stars, req.stat, req.editionStat, req.image
            )
        }
    }
}