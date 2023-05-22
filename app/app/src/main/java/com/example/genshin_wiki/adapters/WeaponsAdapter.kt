package com.example.genshin_wiki.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.genshin_wiki.models.Weapons

class WeaponsAdapter : ListAdapter<Weapons, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class MyDiffCallback : DiffUtil.ItemCallback<Weapons>() {
        override fun areItemsTheSame(
            oldItem: Weapons,
            newItem: Weapons
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Weapons,
            newItem: Weapons
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }


}