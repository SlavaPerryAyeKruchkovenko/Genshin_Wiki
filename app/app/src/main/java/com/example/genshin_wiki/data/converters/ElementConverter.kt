package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.Element
import com.example.genshin_wiki.data.models.enums.Elements
import com.example.genshin_wiki.data.responses.ElementResponse
import com.example.genshin_wiki.database.entities.ElementEntity

data class ElementConverter(
    val id: String,
    val name: String,
    val image: String
) {
    fun toElement(): Element {
        val element = try {
            Elements.valueOf(this.name.uppercase())
        } catch (_: Exception) {
            Elements.NoData
        }
        return Element(
            this.id,
            element,
            this.image
        )
    }

    fun toElementEntity(): ElementEntity {
        return ElementEntity(this.id, this.name, this.image)
    }

    companion object {
        fun default(): ElementConverter {
            return ElementConverter("0", "NoData", "")
        }

        fun fromElementEntity(entity: ElementEntity): ElementConverter {
            return ElementConverter(
                entity.id, entity.name, entity.image
            )
        }

        fun fromElementResponse(req: ElementResponse): ElementConverter {
            return ElementConverter(
                req.id, req.name, req.image
            )
        }
    }
}