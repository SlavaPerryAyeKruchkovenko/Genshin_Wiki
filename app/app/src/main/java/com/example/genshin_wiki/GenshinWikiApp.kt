package com.example.genshin_wiki

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.genshin_wiki.di.modules.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GenshinWikiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        prefs = applicationContext.getSharedPreferences("HOME_DATA", Context.MODE_PRIVATE)
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@GenshinWikiApp)
            modules(appModules)
        }
    }
    companion object {
        var prefs: SharedPreferences? = null
    }
}
