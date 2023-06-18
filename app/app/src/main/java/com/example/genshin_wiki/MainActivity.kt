package com.example.genshin_wiki

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.genshin_wiki.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val count: UInt = 0u;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingActivity: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingActivity.root)
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
}