package com.example.genshin_wiki.ui.character_portrait

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.genshin_wiki.MainActivity
import com.example.genshin_wiki.R
import com.example.genshin_wiki.adapters.utils.ProfileUtils
import com.example.genshin_wiki.databinding.FragmentCharacterPortraitBinding
import com.example.genshin_wiki.models.CharacterPortrait
import com.example.genshin_wiki.models.CharacterProfile

class CharacterPortraitFragment : Fragment() {
    private var _binding: FragmentCharacterPortraitBinding? = null
    private val binding get() = _binding!!
    private val viewModel = CharacterPortraitViewModel()
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

    private fun hideNavigationBar() {
        try {
            val mainActivity = activity as MainActivity
            mainActivity.hideBottomNavigationView()
        } catch (_: Exception) {

        }
    }

    private fun showNavigationBar() {
        try {
            val mainActivity = activity as MainActivity
            mainActivity.showBottomNavigationView()
        } catch (_: Exception) {

        }
    }

    private fun init() {
        hideNavigationBar()
        initAppbar()
        initPortrait()
    }

    private fun initAppbar() {
        binding.appbar.toolBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initPortrait() {
        val characterObserver = Observer<CharacterPortrait> { newValue ->
            if (newValue.profile != null) {
                initInfoBlock(newValue.profile)
            }
            ProfileUtils.loadImage(
                ProfileUtils.getImageFromGoogle(newValue.image),
                binding.image,
                R.drawable.loader_animation
            )
            binding.location.text = newValue.location
            binding.gender.text = if (newValue.sex) {
                getString(R.string.male)
            } else {
                getString(R.string.female)
            }
            binding.birthday.text = newValue.birthday
            binding.description.text = newValue.description
            binding.normalAttack.text = newValue.normalAttack
            binding.elementalSkill.text = newValue.elementalSkill
            binding.elementalBurst.text = newValue.elementalBurst
        }
        viewModel.characterPortrait.observe(viewLifecycleOwner, characterObserver)
    }

    private fun initInfoBlock(profile: CharacterProfile) {
        val infoBlock = binding.infoBlock
        infoBlock.name.text = profile.name
        ProfileUtils.loadImage(
            ProfileUtils.getImageFromGoogle(profile.element.image),
            infoBlock.element,
            R.drawable.loader_animation
        )
        ProfileUtils.loadImage(
            ProfileUtils.getImageFromGoogle(profile.weaponType.image),
            infoBlock.weaponType,
            R.drawable.loader_animation
        )
        if (profile.stars in 4..5) {
            infoBlock.stars.setImageResource(ProfileUtils.getImageByStars(profile.stars))
        } else {
            infoBlock.stars.setImageResource(R.drawable.broken_image)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        showNavigationBar()
    }
}