package com.example.genshin_wiki.ui.weapon_portrait

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.genshin_wiki.R
import com.example.genshin_wiki.adapters.utils.ProfileUtils
import com.example.genshin_wiki.databinding.FragmentWeaponPortraitBinding
import com.example.genshin_wiki.models.Weapon
import com.example.genshin_wiki.ui.NavigationBarHelper

class WeaponPortraitFragment : Fragment() {
    private var _binding: FragmentWeaponPortraitBinding? = null
    private val binding get() = _binding!!
    private val viewModel = WeaponPortraitViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeaponPortraitBinding.inflate(inflater, container, false)
        init()
        if (arguments != null) {
            val id = this.arguments?.getString("weapon_id")
            if (id != null) {
                viewModel.init(id)
            }
        }
        return binding.root
    }

    private fun init() {
        NavigationBarHelper.hideNavigationBar(activity)
        initAppbar()
        initArtifactPortrait()
        initLikeBtn()
    }

    private fun initAppbar() {
        binding.appbar.toolBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initArtifactPortrait() {
        val weaponObserver = Observer<Weapon?> { newValue ->
            initWeapon(newValue)
        }
        viewModel.liveData.observe(viewLifecycleOwner, weaponObserver)
    }

    private fun initWeapon(weapon: Weapon) {
        binding.portraitImage.name.text = weapon.name
        binding.portraitImage.stars.setImageResource(ProfileUtils.getImageByStars(weapon.stars))
        binding.weaponType.text = weapon.type.name
        binding.stat.text = getString(weapon.stat.value)
        binding.secondStat.text = getString(weapon.editionStat.value)
        binding.description.text = weapon.description
        binding.passiveAbility.text = weapon.passiveAbility

        val color = ProfileUtils.getColorByStars(weapon.stars)
        ProfileUtils.loadImage(
            ProfileUtils.getImageFromGoogle(weapon.image),
            binding.portraitImage.image,
            R.drawable.loader_animation
        )
        binding.portraitImage.portraitBlock.backgroundTintList =
            ColorStateList.valueOf(
                ContextCompat.getColor(
                    requireContext(),
                    color
                )
            )
        binding.separator1.dividerColor = ContextCompat.getColor(
            requireContext(),
            color
        )
        binding.separator2.dividerColor = ContextCompat.getColor(
            requireContext(),
            color
        )
        binding.separator3.dividerColor = ContextCompat.getColor(
            requireContext(),
            color
        )
    }

    private fun initLikeBtn() {
        binding.appbar.toolBar.setOnMenuItemClickListener {
            when (it?.itemId) {
                R.id.like -> {
                    viewModel.changeLike()
                    true
                }
                else -> false
            }
        }
        val likeObserver = Observer<Boolean> { newValue ->
            val likeIcon = binding.appbar.toolBar.menu.findItem(R.id.like)
            if (newValue) {
                likeIcon.setIcon(R.drawable.heart_like)
            } else {
                likeIcon.setIcon(R.drawable.heart)
            }
        }
        viewModel.isLiked.observe(viewLifecycleOwner, likeObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        NavigationBarHelper.showNavigationBar(activity)
    }
}