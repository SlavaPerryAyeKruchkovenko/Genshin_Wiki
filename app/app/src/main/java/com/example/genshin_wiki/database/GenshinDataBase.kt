package com.example.genshin_wiki.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.genshin_wiki.database.dao.ArtifactDao
import com.example.genshin_wiki.database.dao.CharacterDao
import com.example.genshin_wiki.database.dao.WeaponDao
import com.example.genshin_wiki.database.entities.*

@Database(
    entities = [ArtifactEntity::class, CharacterEntity::class, CharacterPortraitEntity::class,
        DungeonResourceEntity::class, ElementEntity::class, WeaponEntity::class,
        WeaponTypeEntity::class], version = 2
)
abstract class GenshinDataBase: RoomDatabase() {
    abstract fun weaponsDao(): WeaponDao
    abstract fun artifactsDao(): ArtifactDao
    abstract fun charactersDao(): CharacterDao
}