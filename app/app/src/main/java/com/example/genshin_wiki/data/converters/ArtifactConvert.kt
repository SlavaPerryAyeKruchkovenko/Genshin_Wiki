package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.Artifact
import com.example.genshin_wiki.data.responses.ArtifactResponse

class ArtifactConvert(
    val id: String,
    val isLiked: Boolean,
    val image: String,
    val name: String,
    val stars: Int,
    private val bonus2: String,
    private val bonus4: String
) {
    fun toArtifact(): Artifact {
        return Artifact(this.id, this.image, this.name, this.stars, this.bonus2, this.bonus4)
    }
    companion object{
        fun fromArtifactResponse(req: ArtifactResponse): ArtifactConvert {
            return ArtifactConvert(
                req.id,
                false,
                req.image,
                req.name,
                req.stars,
                req.bonus2,
                req.bonus4
            )
        }
    }
}