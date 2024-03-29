package com.example.genshin_wiki.ui.artifact_portrait

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
import com.example.genshin_wiki.data.models.Artifact
import com.example.genshin_wiki.databinding.FragmentArtifactPortraitBinding
import com.example.genshin_wiki.ui.NavigationBarHelper
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ArtifactPortraitFragment : Fragment() {
    private var _binding: FragmentArtifactPortraitBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy { getViewModel<ArtifactPortraitViewModel>() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArtifactPortraitBinding.inflate(inflater, container, false)
        init()
        if (arguments != null) {
            val id = this.arguments?.getString("artifact_id")
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
        val artifactObserver = Observer<Artifact?> { newValue ->
            initArtifact(newValue)
        }
        viewModel.artifactPortrait.observe(viewLifecycleOwner, artifactObserver)
    }

    private fun initArtifact(artifact: Artifact) {
        binding.portraitImage.name.text = artifact.name
        val image = ProfileUtils.getImageFromGoogle(artifact.image)
        if (image != null) {
            ProfileUtils.loadImage(
                image,
                binding.portraitImage.image,
                R.drawable.loader_animation
            )
        }

        binding.portraitImage.stars.setImageResource(ProfileUtils.getImageByStars(artifact.stars))
        binding.pieceBonus2.text = artifact.bonus2
        binding.pieceBonus4.text = artifact.bonus4

        val color = ProfileUtils.getColorByStars(artifact.stars)
        binding.portraitImage.portraitBlock.backgroundTintList =
            ColorStateList.valueOf(
                ContextCompat.getColor(
                    requireContext(),
                    color
                )
            )
        binding.separator.dividerColor = ContextCompat.getColor(
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