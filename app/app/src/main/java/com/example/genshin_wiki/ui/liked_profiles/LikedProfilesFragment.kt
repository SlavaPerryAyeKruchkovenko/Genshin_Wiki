package com.example.genshin_wiki.ui.liked_profiles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.genshin_wiki.MainActivity
import com.example.genshin_wiki.databinding.FragmentLikedProfilesBinding
import com.example.genshin_wiki.ui.home.HomeViewModel

class LikedProfilesFragment : Fragment() {
    private var _binding: FragmentLikedProfilesBinding? = null
    private val binding get() = _binding!!
    private val viewModel = HomeViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLikedProfilesBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        hideNavigationBar()
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