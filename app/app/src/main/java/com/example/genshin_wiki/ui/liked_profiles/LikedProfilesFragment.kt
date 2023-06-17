package com.example.genshin_wiki.ui.liked_profiles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.genshin_wiki.R
import com.example.genshin_wiki.adapters.LikedAdapter
import com.example.genshin_wiki.databinding.FragmentLikedProfilesBinding
import com.example.genshin_wiki.interfaces.LikedListener
import com.example.genshin_wiki.models.Artifact
import com.example.genshin_wiki.models.CharacterProfile
import com.example.genshin_wiki.models.Likeable
import com.example.genshin_wiki.models.Weapon
import com.example.genshin_wiki.ui.NavigationBarHelper

class LikedProfilesFragment : Fragment(), LikedListener {
    private var _binding: FragmentLikedProfilesBinding? = null
    private val binding get() = _binding!!
    private val viewModel = LikedProfilesViewModel()
    private val likedAdapter = LikedAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLikedProfilesBinding.inflate(inflater, container, false)
        init()
        viewModel.init()
        return binding.root
    }

    private fun init() {
        NavigationBarHelper.hideNavigationBar(activity)
        initAppBar()
        initLikedProfiles()
        initClearBtn()
    }

    private fun initLikedProfiles() {
        binding.likedProfiles.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        binding.likedProfiles.adapter = likedAdapter
        val observer = Observer<List<Likeable>> { newValue ->
            likedAdapter.submitList(newValue)
        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
    }

    private fun initClearBtn() {
        binding.clear.setOnClickListener {
            viewModel.clearLiked()
        }
    }

    private fun initAppBar() {
        binding.toolBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        NavigationBarHelper.showNavigationBar(activity)
    }

    override fun onClick(profile: Artifact) {
        val bundle = Bundle()
        bundle.apply {
            putString("artifact_id", profile.id)
        }
        findNavController().navigate(R.id.action_liked_to_artifact_portrait, bundle)
    }

    override fun onClick(profile: CharacterProfile) {
        val bundle = Bundle()
        bundle.apply {
            putString("character_id", profile.characterId)
        }
        findNavController().navigate(R.id.action_liked_to_character_portrait, bundle)
    }

    override fun onClick(profile: Weapon) {
        TODO("Not yet implemented")
    }
}