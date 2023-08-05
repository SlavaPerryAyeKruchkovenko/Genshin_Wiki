package com.example.genshin_wiki

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.example.genshin_wiki.database.GenshinDataBase
import com.example.genshin_wiki.database.dao.ArtifactDao
import com.example.genshin_wiki.database.dao.CharacterDao
import com.example.genshin_wiki.database.dao.DungeonResourceDao
import com.example.genshin_wiki.database.dao.WeaponDao
import com.example.genshin_wiki.database.migrations.AddDayOfWeekMigration
import com.example.genshin_wiki.database.migrations.ChangeSexTypeMigration
import com.example.genshin_wiki.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        this._binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        database = Room.databaseBuilder(
            applicationContext,
            GenshinDataBase::class.java,
            "GenshinDataBaseName"
        ).addMigrations(ChangeSexTypeMigration())
            .addMigrations(AddDayOfWeekMigration()).build()

        prefs = applicationContext.getSharedPreferences("HOME_DATA", Context.MODE_PRIVATE)
    }

    private fun init() {
        val navView = binding.navigationBar
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)
                    as NavHostFragment
        val navController = navHostFragment.navController
        navView.setupWithNavController(navController)
    }

    fun hideBottomNavigationView() {
        binding.navigationBar.visibility = View.GONE
    }

    fun showBottomNavigationView() {
        binding.navigationBar.visibility = View.VISIBLE
    }

    companion object {
        var prefs: SharedPreferences? = null
        var database: GenshinDataBase? = null
        fun getWeaponDao(): WeaponDao? {
            return database?.weaponsDao()
        }

        fun getArtifactDao(): ArtifactDao? {
            return database?.artifactsDao()
        }

        fun getCharacterDao(): CharacterDao? {
            return database?.charactersDao()
        }

        fun getResourceDao(): DungeonResourceDao? {
            return database?.resourcesDao()
        }
    }
}