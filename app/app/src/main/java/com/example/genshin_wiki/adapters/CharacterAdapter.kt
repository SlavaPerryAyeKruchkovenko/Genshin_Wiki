package com.example.genshin_wiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.genshin_wiki.R
import com.example.genshin_wiki.adapters.utils.ProfileUtils
import com.example.genshin_wiki.databinding.CharacterProfileBinding
import com.example.genshin_wiki.models.CharacterProfile

class CharacterAdapter : ListAdapter<CharacterProfile, RecyclerView.ViewHolder>(MyDiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        return R.id.navigation_characters
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.id.navigation_characters -> {
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
            R.id.navigation_characters -> (holder as CharacterProfileHolder).bind(getItem(position))
            else -> throw IllegalStateException("Unknown item view type ${holder.itemViewType}")
        }
    }
    inner class CharacterProfileHolder(private val binding: CharacterProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(profile: CharacterProfile) = with(binding) {
            name.text = profile.name
            ProfileUtils.loadImage(
                ProfileUtils.getImageFromGoogle(profile.image),
                character,
                R.drawable.loader_animation
            )
            ProfileUtils.loadImage(
                ProfileUtils.getImageFromGoogle(profile.element.image),
                element,
                R.drawable.loader_animation
            )
            ProfileUtils.loadImage(
                ProfileUtils.getImageFromGoogle(profile.weaponType.image),
                weaponType,
                R.drawable.loader_animation
            )
            if (profile.stars in 4..5) {
                stars.setImageResource(ProfileUtils.getImageByStars(profile.stars))
            } else {
                stars.setImageResource(R.drawable.broken_image)
            }
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