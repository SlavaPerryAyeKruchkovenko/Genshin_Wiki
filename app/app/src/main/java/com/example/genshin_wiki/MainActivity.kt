package com.example.genshin_wiki

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.example.genshin_wiki.database.GenshinDataBase
import com.example.genshin_wiki.database.dao.WeaponDao
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
        ).build()
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
        var database: GenshinDataBase? = null
        fun getWeaponDao(): WeaponDao? {
            return database?.weaponsDao()
        }
    }
}