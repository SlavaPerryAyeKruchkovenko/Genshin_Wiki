package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.DungeonResource
import com.example.genshin_wiki.data.responses.CharacterPortraitResponse
import com.example.genshin_wiki.data.responses.DungeonResourceResponse

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

    companion object {
        fun fromDungeonResourceResponse(req: DungeonResourceResponse): DungeonResourceConvert {
            return DungeonResourceConvert(
                req.id,
                req.location,
                req.city,
                req.image
            )
        }
    }
}