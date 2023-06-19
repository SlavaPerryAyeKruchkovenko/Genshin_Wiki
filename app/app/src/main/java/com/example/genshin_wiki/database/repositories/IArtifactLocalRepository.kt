package com.example.genshin_wiki.database.repositories

import com.example.genshin_wiki.data.converters.ArtifactConvert
import com.example.genshin_wiki.database.entities.ArtifactEntity

interface IArtifactLocalRepository {
    suspend fun addWeapons(weapons: List<ArtifactEntity>)
    suspend fun updateWeapon(weapon: ArtifactConvert)
    suspend fun getWeapons(): List<ArtifactEntity>?
    suspend fun getLikedWeapons(): List<ArtifactEntity>?
    suspend fun getWeapon(id: String): ArtifactEntity?
}