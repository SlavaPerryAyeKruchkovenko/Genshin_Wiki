package com.example.genshin_wiki.data.convert_models

import com.example.genshin_wiki.data.models.Element
import com.example.genshin_wiki.data.models.enums.Elements
import com.example.genshin_wiki.data.response.ElementResponse

data class ElementConverter(
    val id: String,
    val name: String,
    val image: String
) {
    fun toElement(): Element {
        return Element(
            this.id,
            Elements.valueOf(this.name.toUpperCase()),
            this.image
        )
    }

    companion object {
        fun fromElementRequestResponse(req: ElementResponse): ElementConverter {
            return ElementConverter(
                req.id, req.name, req.image
            )
        }
    }
}