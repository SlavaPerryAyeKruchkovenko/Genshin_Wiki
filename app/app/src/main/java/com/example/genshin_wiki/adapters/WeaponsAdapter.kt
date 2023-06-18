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
import com.example.genshin_wiki.databinding.WeaponProfileBinding
import com.example.genshin_wiki.interfaces.WeaponListener
import com.example.genshin_wiki.data.models.Weapon

class WeaponsAdapter(private val listener: WeaponListener) :
    ListAdapter<Weapon, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun getItemViewType(position: Int): Int {
        return R.id.navigation_weapons
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.id.navigation_weapons -> {
                val binding = WeaponProfileBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                WeaponsProfileHolder(parent.context, binding)
            }
            else -> throw IllegalStateException("Unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            R.id.navigation_weapons -> (holder as WeaponsProfileHolder).bind(getItem(position))
            else -> throw IllegalStateException("Unknown item view type ${holder.itemViewType}")
        }
    }

    inner class WeaponsProfileHolder(
        private val context: Context,
        private val binding: WeaponProfileBinding
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
    class MyDiffCallback : DiffUtil.ItemCallback<Weapon>() {
        override fun areItemsTheSame(
            oldItem: Weapon,
            newItem: Weapon
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Weapon,
            newItem: Weapon
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}