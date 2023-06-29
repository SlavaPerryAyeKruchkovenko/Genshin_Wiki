package com.example.genshin_wiki.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class AddDayOfWeekMigration : Migration(3, 4) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE DungeonResourceEntity_temp (" +
                    "id TEXT PRIMARY KEY NOT NULL," +
                    "location TEXT NOT NULL," +
                    "city TEXT NOT NULL," +
                    "image TEXT NOT NULL," +
                    "dayOfWeek INTEGER NOT NULL)"
        )

        database.execSQL(
            "INSERT INTO DungeonResourceEntity_temp (id, location, city, image, dayOfWeek) " +
                    "SELECT id, location, city, image, 1 " +
                    "FROM DungeonResourceEntity"
        )

        database.execSQL("DROP TABLE DungeonResourceEntity")

        database.execSQL("ALTER TABLE DungeonResourceEntity_temp RENAME TO DungeonResourceEntity")
    }
}