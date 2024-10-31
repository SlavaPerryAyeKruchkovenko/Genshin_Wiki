package com.example.genshin_wiki.di.modules

import androidx.room.Room
import com.example.genshin_wiki.database.GenshinDataBase
import com.example.genshin_wiki.database.migrations.AddDayOfWeekMigration
import com.example.genshin_wiki.database.migrations.ChangeSexTypeMigration
import org.koin.dsl.module

val dataBaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            GenshinDataBase::class.java,
            "GenshinDataBaseName"
        ).addMigrations(ChangeSexTypeMigration(),AddDayOfWeekMigration()).build()
    }
    single {
        get<GenshinDataBase>().artifactsDao()
    }
    single {
        get<GenshinDataBase>().weaponsDao()
    }
    single {
        get<GenshinDataBase>().charactersDao()
    }
    single {
        get<GenshinDataBase>().resourcesDao()
    }
/*    single<SharedPreferences> {
        get<Context>().getSharedPreferences("HOME_DATA", Context.MODE_PRIVATE)
    }*/
}
