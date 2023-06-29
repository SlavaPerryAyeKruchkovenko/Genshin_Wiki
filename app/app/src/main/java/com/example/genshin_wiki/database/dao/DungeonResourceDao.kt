package com.example.genshin_wiki.database.dao

import androidx.room.*
import com.example.genshin_wiki.database.entities.DungeonResourceEntity

@Dao
interface DungeonResourceDao {
    @Query("Select * from DungeonResourceEntity WHERE dayOfWeek = :day")
    suspend fun getResourcesByDay(day: Int): List<DungeonResourceEntity>

    @Query("DELETE FROM DungeonResourceEntity WHERE dayOfWeek = :day")
    suspend fun deleteResourcesByDay(day: Int)

    @Transaction
    suspend fun softInsertResources(resources: List<DungeonResourceEntity>, day: Int) {
        deleteResourcesByDay(day)
        insertResources(resources)
    }

    @Insert
    suspend fun insertResources(resources: List<DungeonResourceEntity>)
}