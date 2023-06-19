package com.example.genshin_wiki.adapters.utils

import android.util.Log
import android.widget.ImageView
import com.example.genshin_wiki.R
import com.squareup.picasso.Picasso

class ProfileUtils {
    companion object{
        fun getColorByStars(stars: Int): Int {
            return when (stars) {
                5 -> R.color.stars_5
                4 -> R.color.stars_4
                3 -> R.color.stars_3
                2 -> R.color.stars_2
                1 -> R.color.stars_1
                else -> R.color.white
            }
        }

        fun getImageByStars(stars: Int): Int {
            return when (stars) {
                5 -> R.drawable.five_stars
                4 -> R.drawable.fourth_stars
                3 -> R.drawable.three_stars
                2 -> R.drawable.two_stars
                1 -> R.drawable.one_star
                else -> R.drawable.broken_image
                
            }
        }

        fun getImageFromGoogle(googleImage: String): String? {
            val splitArray = googleImage.split("/")
            return if (splitArray.size >= 6) {
                val imageId = splitArray[5]
                "https://drive.google.com/uc?export=view&id=${imageId}"
            } else {
                null
            }
        }

        fun loadImage(image: String, imageView: ImageView, placeholder: Int) {
            try {
                Picasso.get().load(image)
                    .placeholder(placeholder)
                    .error(R.drawable.broken_image)
                    .into(imageView)
            } catch (ex: Exception) {
                Log.e("Error", ex.message.toString())
                ex.printStackTrace()
            }
        }
    }
}