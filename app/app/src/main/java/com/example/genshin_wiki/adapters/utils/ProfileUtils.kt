package com.example.genshin_wiki.adapters.utils

import android.util.Log
import android.widget.ImageView
import com.example.genshin_wiki.R
import com.example.genshin_wiki.models.enums.Elements
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

        fun getGeoElement(element: Elements): Int {
            return when (element) {
                Elements.PYRO -> R.color.pyro_element
                Elements.HYDRO -> R.color.hydro_element
                Elements.ANEMO -> R.color.anemo_element
                Elements.ELECTRO -> R.color.electro_element
                Elements.DENDRO -> R.color.dendro_element
                Elements.CRYO -> R.color.cryo_element
                Elements.GEO -> R.color.geo_element
                else -> R.color.white
            }
        }

        fun getGeoElementSecond(element: Elements): Int {
            return when (element) {
                Elements.PYRO -> R.color.pyro_description
                Elements.HYDRO -> R.color.hydro_description
                Elements.ANEMO -> R.color.anemo_description
                Elements.ELECTRO -> R.color.electro_description
                Elements.DENDRO -> R.color.dendro_description
                Elements.CRYO -> R.color.cryo_description
                Elements.GEO -> R.color.geo_description
                else -> R.color.white
            }
        }

        fun getImageFromGoogle(googleImage: String): String {
            val imageId = googleImage.split("/")[5]
            return "https://drive.google.com/uc?export=view&id=${imageId}"
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