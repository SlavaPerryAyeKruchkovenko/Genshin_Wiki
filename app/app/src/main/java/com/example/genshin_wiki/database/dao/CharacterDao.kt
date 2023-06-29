package com.example.genshin_wiki.database.dao

import androidx.room.*
import com.example.genshin_wiki.database.entities.CharacterEntity

@Dao
interface CharacterDao {
    @Query("Select * from CharacterEntity")
    suspend fun getAllCharacters(): List<CharacterEntity>

    @Query("SELECT * FROM CharacterEntity WHERE id = :id")
    suspend fun getCharacterById(id: String): CharacterEntity?

    @Query("SELECT * FROM CharacterEntity WHERE isLike = 1")
    suspend fun getLikedCharacter(): List<CharacterEntity>

    @Query("Delete from CharacterEntity")
    suspend fun deleteCharacters()
    @Query("UPDATE CharacterEntity SET isLike = 0")
    suspend fun dislikeAllCharacters()
    @Transaction
    suspend fun softInsertCharacters(characters: List<CharacterEntity>) {
        val dbCharacters = getAllCharacters()
        characters.forEach { character ->
            val dbCharacter = dbCharacters.find { it.id == character.id }
            character.isLike = dbCharacter?.isLike ?: 0
        }
        deleteCharacters()
        insertCharacters(characters)
    }

    @Update
    suspend fun update(character: CharacterEntity)

    @Insert
    suspend fun insertCharacters(characters: List<CharacterEntity>)
}