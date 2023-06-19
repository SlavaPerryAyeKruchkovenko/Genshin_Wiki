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
import com.example.genshin_wiki.data.models.Artifact
import com.example.genshin_wiki.databinding.ArtifactProfileBinding
import com.example.genshin_wiki.interfaces.listeners.ArtifactListener

class ArtifactAdapter(private val listener: ArtifactListener) : ListAdapter<Artifact, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun getItemViewType(position: Int): Int {
        return R.id.navigation_artifacts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.id.navigation_artifacts -> {
                val binding = ArtifactProfileBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                ArtifactProfileHolder(parent.context, binding)
            }
            else -> throw IllegalStateException("Unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            R.id.navigation_artifacts -> (holder as ArtifactProfileHolder).bind(getItem(position))
            else -> throw IllegalStateException("Unknown item view type ${holder.itemViewType}")
        }
    }

    inner class ArtifactProfileHolder(
        private val context: Context,
        private val binding: ArtifactProfileBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(artifactObj: Artifact) = with(binding) {
            itemView.setOnClickListener {
                listener.onClick(artifactObj)
            }
            val image = ProfileUtils.getImageFromGoogle(artifactObj.image)
            if (image != null) {
                ProfileUtils.loadImage(
                    image,
                    artifact,
                    R.drawable.loader_animation
                )
            }
            name.text = artifactObj.name
            artifactBlock.backgroundTintList =
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        context,
                        ProfileUtils.getColorByStars(artifactObj.stars)
                    )
                )
            stars.setImageResource(ProfileUtils.getImageByStars(artifactObj.stars))
        }
    }

    class MyDiffCallback : DiffUtil.ItemCallback<Artifact>() {
        override fun areItemsTheSame(
            oldItem: Artifact,
            newItem: Artifact
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Artifact,
            newItem: Artifact
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}