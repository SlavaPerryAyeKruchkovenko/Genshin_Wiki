package com.example.genshin_wiki.ui.weapon_portrait

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.genshin_wiki.databinding.FragmentWeaponPortraitBinding
import com.example.genshin_wiki.ui.artifact_portrait.ArtifactPortraitViewModel

class WeaponPortraitFragment : Fragment() {
    private var _binding: FragmentWeaponPortraitBinding? = null
    private val binding get() = _binding!!
    private val viewModel = ArtifactPortraitViewModel()
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
    private fun init(){

    }
}