package com.example.genshin_wiki.data.converters

import androidx.room.Embedded
import com.example.genshin_wiki.data.models.Weapon
import com.example.genshin_wiki.data.models.enums.Stats
import com.example.genshin_wiki.data.responses.WeaponResponse
import com.example.genshin_wiki.database.entities.WeaponEntity
import com.example.genshin_wiki.database.entities.WeaponTypeEntity

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
        val stat = try {
            Stats.valueOf(this.stat.uppercase())
        } catch (_: Exception) {
            Stats.NoData
        }
        val editionStat = try {
            Stats.valueOf(this.editionStat.uppercase())
        } catch (_: Exception) {
            Stats.NoData
        }

        return Weapon(
            this.id,
            this.name,
            this.description,
            this.type.toWeaponType(),
            this.passiveAbility,
            this.stars,
            stat,
            editionStat,
            this.image
        )
    }

    fun toWeaponEntity(): WeaponEntity {
        return WeaponEntity(
            this.id,
            0,
            this.name,
            this.description,
            this.type.toWeaponTypeEntity(),
            this.passiveAbility,
            this.stars,
            this.stat,
            this.editionStat,
            this.image,
        )
    }

    companion object {
        fun default(): WeaponConverter {
            return WeaponConverter(
                "0", false, "no data", "no data",
                WeaponTypeConvert.default(), "no data", 5,
                "NoData", "NoData", ""
            )
        }

        fun fromWeaponResponse(req: WeaponResponse): WeaponConverter {
            val type = WeaponTypeConvert.fromWeaponTypeResponse(req.type)
            return WeaponConverter(
                req.id, false, req.name, req.description, type, req.passiveAbility,
                req.stars, req.stat, req.editionStat, req.image
            )
        }
        fun fromWeaponEntity(entity: WeaponEntity): WeaponConverter {
            val type = WeaponTypeConvert.fromWeaponTypeEntity(entity.type)
            val isLike = entity.isLike > 0
            return WeaponConverter(
                entity.id, isLike, entity.name, entity.description, type, entity.passiveAbility,
                entity.stars, entity.stat, entity.editionStat, entity.image
            )
        }
    }
}