package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.Element
import com.example.genshin_wiki.data.models.enums.Elements
import com.example.genshin_wiki.data.responses.ElementResponse

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

    companion object {
        fun default(): ElementConverter {
            return ElementConverter("0", "NoData", "")
        }
        fun fromElementResponse(req: ElementResponse): ElementConverter {
            return ElementConverter(
                req.id, req.name, req.image
            )
        }
    }
}