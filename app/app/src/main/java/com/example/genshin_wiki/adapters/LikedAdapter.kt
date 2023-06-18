package com.example.genshin_wiki.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.genshin_wiki.R
import com.example.genshin_wiki.adapters.utils.ProfileUtils
import com.example.genshin_wiki.databinding.ArtifactProfileLikeableBinding
import com.example.genshin_wiki.databinding.CharacterProfileLikeableBinding
import com.example.genshin_wiki.databinding.WeaponProfileLikeableBinding
import com.example.genshin_wiki.interfaces.LikedListener
import com.example.genshin_wiki.data.models.Artifact
import com.example.genshin_wiki.data.models.Character
import com.example.genshin_wiki.data.models.Likeable
import com.example.genshin_wiki.data.models.Weapon

class LikedAdapter(private val listener: LikedListener) :
    ListAdapter<Likeable, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Artifact -> R.layout.artifact_profile
            is Weapon -> R.layout.weapon_profile
            is Character -> R.layout.character_profile
            else -> Int.MAX_VALUE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.artifact_profile -> {
                val binding = ArtifactProfileLikeableBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                ArtifactProfileHolder(parent.context, binding)
            }
            R.layout.weapon_profile -> {
                val binding = WeaponProfileLikeableBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                WeaponProfileHolder(parent.context, binding)
            }
            R.layout.character_profile -> {
                val binding = CharacterProfileLikeableBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                CharacterProfileHolder(parent.context, binding)
            }
            else -> throw IllegalStateException("Unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            R.layout.artifact_profile -> (holder as LikedAdapter.ArtifactProfileHolder).bind(
                getItem(position) as Artifact
            )
            R.layout.weapon_profile -> (holder as LikedAdapter.WeaponProfileHolder).bind(
                getItem(position) as Weapon
            )
            R.layout.character_profile -> (holder as LikedAdapter.CharacterProfileHolder).bind(
                getItem(position) as Character
            )
            else -> throw IllegalStateException("Unknown item view type ${holder.itemViewType}")
        }
    }

    inner class ArtifactProfileHolder(
        private val context: Context,
        private val binding: ArtifactProfileLikeableBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(profile: Artifact) = with(binding) {
            itemView.setOnClickListener {
                listener.onClick(profile)
            }
            name.text = profile.name
            artifactBlock.backgroundTintList =
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        context,
                        ProfileUtils.getColorByStars(profile.stars)
                    )
                )
            ProfileUtils.loadImage(
                ProfileUtils.getImageFromGoogle(profile.image),
                artifact,
                R.drawable.loader_animation
            )
            stars.setImageResource(ProfileUtils.getImageByStars(profile.stars))
        }
    }

    inner class WeaponProfileHolder(
        private val context: Context,
        private val binding: WeaponProfileLikeableBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(profile: Weapon) = with(binding) {
            itemView.setOnClickListener {
                listener.onClick(profile)
            }
            name.text = profile.name
            weaponBlock.backgroundTintList =
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        context,
                        ProfileUtils.getColorByStars(profile.stars)
                    )
                )
            ProfileUtils.loadImage(
                ProfileUtils.getImageFromGoogle(profile.image),
                weapon,
                R.drawable.loader_animation
            )
            ProfileUtils.loadImage(
                ProfileUtils.getImageFromGoogle(profile.type.image),
                weaponType,
                R.drawable.loader_animation
            )
            stars.setImageResource(ProfileUtils.getImageByStars(profile.stars))
        }
    }

    inner class CharacterProfileHolder(
        private val context: Context,
        private val binding: CharacterProfileLikeableBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(profile: Character) = with(binding) {
            itemView.setOnClickListener {
                listener.onClick(profile)
            }
            name.text = profile.name
            characterBlock.backgroundTintList =
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        context,
                        ProfileUtils.getColorByStars(profile.stars)
                    )
                )
            ProfileUtils.loadImage(
                ProfileUtils.getImageFromGoogle(profile.image),
                character,
                R.drawable.loader_animation
            )
            ProfileUtils.loadImage(
                ProfileUtils.getImageFromGoogle(profile.weaponType.image),
                weaponType,
                R.drawable.loader_animation
            )
            ProfileUtils.loadImage(
                ProfileUtils.getImageFromGoogle(profile.element.image),
                element,
                R.drawable.loader_animation
            )
            stars.setImageResource(ProfileUtils.getImageByStars(profile.stars))
        }
    }

    class MyDiffCallback : DiffUtil.ItemCallback<Likeable>() {
        override fun areItemsTheSame(
            oldItem: Likeable,
            newItem: Likeable
        ): Boolean {
            return oldItem.liked_id == newItem.liked_id
        }

        override fun areContentsTheSame(
            oldItem: Likeable,
            newItem: Likeable
        ): Boolean {
            return oldItem.liked_id == newItem.liked_id
        }
    }
}