package com.example.genshin_wiki

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.genshin_wiki.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val count: UInt = 0u;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingActivity: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingActivity.root)
    }

    private fun init(){
        /*bottomNavigationView.getMenu().findItem(R.id.navigationBarBackground)
            .setIcon(R.drawable.ic_weapons)
        bottomNavigationView.setOnNavigationItemSelectedListener(object :
            OnNavigationItemSelectedListener() {
            fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                when (item.getItemId()) {
                    R.id.navigation_weapons -> item.getIcon()
                        .setTint(ContextCompat.getColor(context, R.color.white))
                }
                return true
            }
        })*/

    }
}