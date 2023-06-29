package com.example.genshin_wiki.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class ChangeSexTypeMigration : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE CharacterPortraitEntity_temp (" +
                    "portrait_id TEXT PRIMARY KEY NOT NULL," +
                    "portrait_image TEXT NOT NULL," +
                    "location TEXT NOT NULL," +
                    "sex INTEGER NOT NULL," +
                    "birthday TEXT NOT NULL," +
                    "portrait_description TEXT NOT NULL," +
                    "normalAttack TEXT NOT NULL," +
                    "elementalSkill TEXT NOT NULL," +
                    "elementalBurst TEXT NOT NULL)"
        )

        database.execSQL(
            "INSERT INTO CharacterPortraitEntity_temp (portrait_id, portrait_image, location, sex, birthday, portrait_description, normalAttack, elementalSkill, elementalBurst) " +
                    "SELECT portrait_id, portrait_image, location, CASE WHEN sex = 1 THEN 1 ELSE 0 END, birthday, portrait_description, normalAttack, elementalSkill, elementalBurst " +
                    "FROM CharacterPortraitEntity"
        )

        database.execSQL("DROP TABLE CharacterPortraitEntity")

        database.execSQL("ALTER TABLE CharacterPortraitEntity_temp RENAME TO CharacterPortraitEntity")
    }
}