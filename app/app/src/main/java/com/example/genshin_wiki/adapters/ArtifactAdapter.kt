package com.example.genshin_wiki.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.genshin_wiki.R
import com.example.genshin_wiki.databinding.ArtifactProfileBinding
import com.example.genshin_wiki.models.Artifact
import com.squareup.picasso.Picasso


class ArtifactAdapter : ListAdapter<Artifact, RecyclerView.ViewHolder>(MyDiffCallback()) {
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
                ArtifactProfileHolder(binding);
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

    inner class ArtifactProfileHolder(private val binding: ArtifactProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(artifactObj: Artifact) = with(binding) {
            loadImage(artifactObj.image, artifact)
            name.text = artifactObj.name
            loadStars(artifactObj.stars, stars)
        }
        private fun loadImage(googleImage: String, imageView: ImageView) {
            try {
                val imageId = googleImage.split("/")[5]
                val image = "https://drive.google.com/uc?export=view&id=${imageId}"
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
                3 -> {
                    imageView.setImageResource(R.drawable.three_stars)
                }
                2 -> {
                    imageView.setImageResource(R.drawable.three_stars)
                }
                1 -> {
                    imageView.setImageResource(R.drawable.three_stars)
                }
                else -> {
                    imageView.setImageResource(R.drawable.broken_image)
                }
            }
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