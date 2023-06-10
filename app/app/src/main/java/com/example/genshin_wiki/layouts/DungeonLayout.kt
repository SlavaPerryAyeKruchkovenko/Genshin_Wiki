package com.example.genshin_wiki.layouts

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager

class DungeonLayout(context: Context) : GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false,) {
    override fun canScrollHorizontally(): Boolean {
        return super.canScrollHorizontally()
    }

    override fun canScrollVertically(): Boolean {
        return false
    }
}