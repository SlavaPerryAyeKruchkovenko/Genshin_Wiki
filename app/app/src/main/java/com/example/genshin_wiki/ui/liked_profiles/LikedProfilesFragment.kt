package com.example.genshin_wiki.ui.liked_profiles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.genshin_wiki.MainActivity
import com.example.genshin_wiki.adapters.LikedAdapter
import com.example.genshin_wiki.databinding.FragmentLikedProfilesBinding
import com.example.genshin_wiki.models.Likeable

class LikedProfilesFragment : Fragment() {
    private var _binding: FragmentLikedProfilesBinding? = null
    private val binding get() = _binding!!
    private val viewModel = LikedProfilesViewModel()
    private val likedAdapter = LikedAdapter()
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
        hideNavigationBar()
        initAppBar()
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

    private fun initAppBar() {
        binding.toolBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        showNavigationBar()
    }
}