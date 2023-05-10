package com.example.genshin_wiki.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.genshin_wiki.R
import com.example.genshin_wiki.databinding.CharacterProfileBinding
import com.example.genshin_wiki.models.CharacterProfile
import com.squareup.picasso.Picasso

class CharacterAdapter : ListAdapter<CharacterProfile, RecyclerView.ViewHolder>(MyDiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        return R.id.characters_fragment
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.id.characters_fragment -> {
                val binding = CharacterProfileBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                CharacterProfileHolder(binding);
            }
            else -> throw IllegalStateException("Unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            R.id.characters_fragment -> (holder as CharacterProfileHolder).bind(getItem(position))
            else -> throw IllegalStateException("Unknown item view type ${holder.itemViewType}")
        }
    }

    inner class CharacterProfileHolder(private val binding: CharacterProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(profile: CharacterProfile) = with(binding) {
            try {
                Picasso.get().load(profile.image)
                    .placeholder(R.drawable.loader_animation)
                    .error(R.drawable.broken_image)
                    .into(profileImage)
            } catch (ex: Exception) {
                Log.e("Error", ex.message.toString())
                ex.printStackTrace()
            }
            nameText.text = profile.name
        }
    }

    class MyDiffCallback : DiffUtil.ItemCallback<CharacterProfile>() {
        override fun areItemsTheSame(
            oldItem: CharacterProfile,
            newItem: CharacterProfile
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CharacterProfile,
            newItem: CharacterProfile
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}