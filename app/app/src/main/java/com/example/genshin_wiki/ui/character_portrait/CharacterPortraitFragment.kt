package com.example.genshin_wiki.ui.character_portrait

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.genshin_wiki.R
import com.example.genshin_wiki.adapters.utils.ProfileUtils
import com.example.genshin_wiki.data.models.Character
import com.example.genshin_wiki.data.models.CharacterPortrait
import com.example.genshin_wiki.databinding.FragmentCharacterPortraitBinding
import com.example.genshin_wiki.ui.NavigationBarHelper

class CharacterPortraitFragment : Fragment() {
    private var _binding: FragmentCharacterPortraitBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CharacterPortraitViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterPortraitBinding.inflate(inflater, container, false)
        init()
        if (arguments != null) {
            val id = this.arguments?.getString("character_id")
            if (id != null) {
                viewModel.init(id)
            }
        }
        return binding.root
    }

    private fun init() {
        NavigationBarHelper.hideNavigationBar(activity)
        initAppbar()
        initPortrait()
        initLikeBtn()
    }
    private fun initAppbar() {
        binding.appbar.toolBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initPortrait() {
        val characterObserver = Observer<Character?> { newValue ->
            if (newValue != null) {
                initInfoBlock(newValue)
                initPortraitBlock(newValue.portrait)
            }
        }
        viewModel.characterPortrait.observe(viewLifecycleOwner, characterObserver)
    }

    private fun initPortraitBlock(portrait: CharacterPortrait) {
        val image = ProfileUtils.getImageFromGoogle(portrait.image)
        if (image != null) {
            ProfileUtils.loadImage(
                image,
                binding.image,
                R.drawable.loader_animation
            )
        }
        binding.location.text = portrait.location
        binding.gender.text = if (portrait.sex) {
            getString(R.string.male)
        } else {
            getString(R.string.female)
        }
        binding.birthday.text = portrait.birthday
        binding.description.text = portrait.description
        binding.normalAttack.text = portrait.normalAttack
        binding.elementalSkill.text = portrait.elementalSkill
        binding.elementalBurst.text = portrait.elementalBurst
    }

    private fun initInfoBlock(profile: Character) {
        val infoBlock = binding.characterInfo
        infoBlock.name.text = profile.name
        infoBlock.elementName.text = getString(profile.element.name.text)
        infoBlock.weaponName.text = getString(profile.weaponType.name.value)

        val elementImage = ProfileUtils.getImageFromGoogle(profile.element.image)
        val weaponTypeImage = ProfileUtils.getImageFromGoogle(profile.weaponType.image)
        if (elementImage != null) {
            ProfileUtils.loadImage(
                elementImage,
                infoBlock.element,
                R.drawable.loader_animation
            )
        }
        if (weaponTypeImage != null) {
            ProfileUtils.loadImage(
                weaponTypeImage,
                infoBlock.weaponType,
                R.drawable.loader_animation
            )
        }
        if (profile.stars in 4..5) {
            infoBlock.stars.setImageResource(ProfileUtils.getImageByStars(profile.stars))
        } else {
            infoBlock.stars.setImageResource(R.drawable.broken_image)
        }

        val typedValue = TypedValue()
        requireContext().theme.resolveAttribute(
            profile.element.name.colorAttr,
            typedValue,
            true
        )
        val color = typedValue.data
        binding.portraitBlock.backgroundTintList = ColorStateList.valueOf(color)
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