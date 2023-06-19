package com.example.genshin_wiki.database.dao

import androidx.room.*
import com.example.genshin_wiki.database.entities.ArtifactEntity
import com.example.genshin_wiki.database.entities.WeaponEntity

@Dao
interface ArtifactDao {
    @Query("Select * from ArtifactEntity")
    suspend fun getAllArtifacts(): List<ArtifactEntity>

    @Query("SELECT * FROM ArtifactEntity WHERE id = :id")
    suspend fun getArtifactById(id: String): WeaponEntity?

    @Query("SELECT * FROM ArtifactEntity WHERE isLike = 1")
    suspend fun getLikedArtifact(): List<ArtifactEntity>

    @Query("Delete from ArtifactEntity")
    suspend fun deleteArtifacts()

    @Transaction
    suspend fun softInsertArtifacts(artifacts: List<ArtifactEntity>) {
        val dbArtifacts = getAllArtifacts()
        artifacts.forEach { artifact ->
            val dbArtifact = dbArtifacts.find { it.id == artifact.id }
            artifact.isLike = dbArtifact?.isLike ?: 0
        }
        deleteArtifacts()
        insertArtifacts(artifacts)
    }

    @Update
    suspend fun update(artifact: ArtifactEntity)

    @Insert
    suspend fun insertArtifacts(artifacts: List<ArtifactEntity>)
}