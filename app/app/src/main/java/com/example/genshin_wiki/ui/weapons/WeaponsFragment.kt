package com.example.genshin_wiki.ui.weapons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.genshin_wiki.adapters.WeaponsAdapter
import com.example.genshin_wiki.databinding.FragmentWeaponsBinding
import com.example.genshin_wiki.models.Weapon

class WeaponsFragment : Fragment() {
    private var _binding: FragmentWeaponsBinding? = null
    private val binding get() = _binding!!
    private val weaponsAdapter = WeaponsAdapter()
    private val viewModel = WeaponsViewModel()
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}