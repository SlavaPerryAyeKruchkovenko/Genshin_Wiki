package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.DungeonResource
import com.example.genshin_wiki.data.responses.DungeonResourceResponse
import com.example.genshin_wiki.database.entities.DungeonResourceEntity

data class DungeonResourceConvert(
    val id: String,
    val location: String,
    val city: String,
    val image: String
) {
    fun toDungeonResource(): DungeonResource {
        return DungeonResource(
            this.id,
            this.location,
            this.city,
            this.image,
        )
    }

    fun toDungeonResourceEntity(dayOfWeek: Int): DungeonResourceEntity {
        return DungeonResourceEntity(
            this.id,
            this.location,
            this.city,
            this.image,
            dayOfWeek
        )
    }

    companion object {
        fun fromDungeonResourceResponse(req: DungeonResourceResponse): DungeonResourceConvert {
            return DungeonResourceConvert(
                req.id,
                req.location,
                req.city,
                req.image
            )
        }

        fun fromDungeonResourceEntity(entity: DungeonResourceEntity): DungeonResourceConvert {
            return DungeonResourceConvert(
                entity.id, entity.location, entity.city,
                entity.image
            )
        }
    }
}