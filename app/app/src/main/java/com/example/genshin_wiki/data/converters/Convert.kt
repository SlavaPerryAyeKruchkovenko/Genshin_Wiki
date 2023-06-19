package com.example.genshin_wiki.data.converters

import com.example.genshin_wiki.data.models.Likeable

sealed class Convert(
    open val id: String,
    open var isLiked: Boolean
) {
    fun toLikeable(): Likeable {
        return when (this) {
            is ArtifactConvert -> this.toArtifact()
            is WeaponConverter -> this.toWeapon()
            is CharacterConvert -> this.toCharacter()
        }
    }
}