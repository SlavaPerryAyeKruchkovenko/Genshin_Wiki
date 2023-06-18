package com.example.genshin_wiki.ui

import androidx.fragment.app.FragmentActivity
import com.example.genshin_wiki.MainActivity

class NavigationBarHelper {
    companion object {
        fun hideNavigationBar(activity: FragmentActivity?) {
            try {
                val mainActivity = activity as MainActivity
                mainActivity.hideBottomNavigationView()
            } catch (_: Exception) {

            }
        }

        fun showNavigationBar(activity: FragmentActivity?) {
            try {
                val mainActivity = activity as MainActivity
                mainActivity.showBottomNavigationView()
            } catch (_: Exception) {

            }
        }
    }
}