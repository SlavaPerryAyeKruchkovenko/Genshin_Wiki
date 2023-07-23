package com.example.genshin_wiki.ui.weapons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.genshin_wiki.R
import com.example.genshin_wiki.adapters.WeaponsAdapter
import com.example.genshin_wiki.data.models.Weapon
import com.example.genshin_wiki.databinding.FragmentWeaponsBinding
import com.example.genshin_wiki.interfaces.listeners.WeaponListener

class WeaponsFragment : Fragment(), WeaponListener {
    private var _binding: FragmentWeaponsBinding? = null
    private val binding get() = _binding!!
    private val weaponsAdapter = WeaponsAdapter(this)
    private val viewModel by viewModels<WeaponsViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeaponsBinding.inflate(inflater, container, false)
        init()
        viewModel.init()
        return binding.root
    }

    private fun init() {
        binding.weapons.layoutManager = GridLayoutManager(
            context,
            2
        )
        binding.weapons.adapter = weaponsAdapter
        val observer = Observer<List<Weapon>> { newValue ->
            weaponsAdapter.submitList(newValue)
        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
    }

    private fun initSearchBar(){

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(profile: Weapon) {
        val bundle = Bundle()
        bundle.apply {
            putString("weapon_id", profile.id)
        }
        findNavController().navigate(R.id.action_weapons_to_weapon_portrait, bundle)
    }
}