package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.Artifact
import com.example.genshin_wiki.data.responses.ArtifactResponse

class ArtifactConvert(
    override val id: String,
    override var isLiked: Boolean,
    val image: String,
    val name: String,
    val stars: Int,
    private val bonus2: String,
    private val bonus4: String
):Convert(id,isLiked) {
    fun toArtifact(): Artifact {
        val artifact = Artifact(this.id, this.image, this.name, this.stars, this.bonus2, this.bonus4)
        if (isLiked) {
            artifact.like()
        } else {
            artifact.dislike()
        }
        return artifact
    }
    companion object{
        fun default(): ArtifactConvert {
            return ArtifactConvert("0", false, "", "no data", 5, "no data", "no data")
        }

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