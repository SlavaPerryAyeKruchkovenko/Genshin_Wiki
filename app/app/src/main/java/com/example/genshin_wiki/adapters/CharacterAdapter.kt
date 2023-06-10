package com.example.genshin_wiki.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.genshin_wiki.R
import com.example.genshin_wiki.databinding.CharacterProfileBinding
import com.example.genshin_wiki.models.CharacterProfile
import com.squareup.picasso.Picasso

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
            loadImage(profile.image, character)
            name.text = profile.name
            loadImage(profile.element.image, element)
            loadImage(profile.weaponType.image, weaponType)
            loadStars(profile.stars, stars)
        }

        private fun loadImage(image: String, imageView: ImageView) {
            try {
                Picasso.get().load(image)
                    .placeholder(R.drawable.loader_animation)
                    .error(R.drawable.broken_image)
                    .into(imageView)
            } catch (ex: Exception) {
                Log.e("Error", ex.message.toString())
                ex.printStackTrace()
            }
        }

        private fun loadStars(stars: Int, imageView: ImageView) {
            when (stars) {
                5 -> {
                    imageView.setImageResource(R.drawable.five_stars)
                }
                4 -> {
                    imageView.setImageResource(R.drawable.fourth_stars)
                }
                else -> {
                    imageView.setImageResource(R.drawable.broken_image)
                }
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