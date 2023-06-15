package com.example.genshin_wiki.ui.character_portrait

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.genshin_wiki.MainActivity
import com.example.genshin_wiki.databinding.FragmentCharacterPortraitBinding

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
        return binding.root
    }
    private fun hideNavigationBar(){
        try {
            val mainActivity = activity as MainActivity
            mainActivity.hideBottomNavigationView()
        } catch (_: Exception){

        }
    }
    private fun showNavigationBar(){
        try {
            val mainActivity = activity as MainActivity
            mainActivity.showBottomNavigationView()
        } catch (_: Exception){

        }
    }
    private fun init() {
        hideNavigationBar()
    }

    override fun onDestroy() {
        super.onDestroy()
        showNavigationBar()
    }
}