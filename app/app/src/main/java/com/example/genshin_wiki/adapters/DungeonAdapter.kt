package com.example.genshin_wiki.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.genshin_wiki.R
import com.example.genshin_wiki.databinding.DungeonResourceBinding
import com.example.genshin_wiki.models.DungeonResource
import com.squareup.picasso.Picasso

class DungeonAdapter : ListAdapter<DungeonResource, RecyclerView.ViewHolder>(MyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.id.dungeon_panel -> {
                val binding = DungeonResourceBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                DungeonHolder(binding);
            }
            else -> throw IllegalStateException("Unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            R.id.dungeon_panel -> (holder as DungeonHolder).bind(getItem(position))
            else -> throw IllegalStateException("Unknown item view type ${holder.itemViewType}")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.id.dungeon_panel
    }
    inner class DungeonHolder(private val binding: DungeonResourceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(resource: DungeonResource) = with(binding) {
            loadImage(resource.image, image)
            val value = resource.location + ", " + resource.city
            label.text = value
        }

        private fun loadImage(googleImage: String, imageView: ImageView) {
            try {
                val imageId = googleImage.split("/")[5]
                val image = "https://drive.google.com/uc?export=view&id=${imageId}"
                Picasso.get().load(image)
                    .placeholder(R.drawable.loader_dungeon_animation)
                    .error(R.drawable.broken_image)
                    .into(imageView)
            } catch (ex: Exception) {
                Log.e("Error", ex.message.toString())
                ex.printStackTrace()
            }
        }
    }

    class MyDiffCallback : DiffUtil.ItemCallback<DungeonResource>() {
        override fun areItemsTheSame(oldItem: DungeonResource, newItem: DungeonResource): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DungeonResource,
            newItem: DungeonResource
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}