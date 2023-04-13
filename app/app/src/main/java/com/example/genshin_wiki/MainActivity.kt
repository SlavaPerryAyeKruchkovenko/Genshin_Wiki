package com.example.genshin_wiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.genshin_wiki.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val count: UInt = 0u;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingActivity: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingActivity.root)
    }
}