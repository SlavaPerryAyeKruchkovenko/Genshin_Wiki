package com.example.genshin_wiki.ui.weapons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.genshin_wiki.R
import com.example.genshin_wiki.adapters.WeaponsAdapter
import com.example.genshin_wiki.data.models.OutputOf
import com.example.genshin_wiki.data.models.Weapon
import com.example.genshin_wiki.databinding.FragmentWeaponsBinding
import com.example.genshin_wiki.interfaces.listeners.WeaponListener
import org.koin.androidx.viewmodel.ext.android.getViewModel

class WeaponsFragment : Fragment(), WeaponListener {
    private var _binding: FragmentWeaponsBinding? = null
    private val binding get() = _binding!!
    private val weaponsAdapter = WeaponsAdapter(this)
    private val viewModel by lazy { getViewModel<WeaponsViewModel>() }
    private var searchView: SearchView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeaponsBinding.inflate(inflater, container, false)
        searchView = binding.searchAppbar.searchBar
        init()
        viewModel.init()
        return binding.root
    }

    private fun init() {
        initWeaponsRecycle()
        initSearchBar()
    }

    private fun initWeaponsRecycle() {
        binding.weapons.layoutManager = GridLayoutManager(
            context,
            2
        )
        binding.weapons.adapter = weaponsAdapter
        val observer = Observer<OutputOf<List<Weapon>>> { newValue ->
            when (newValue) {
                is OutputOf.Success -> {
                    binding.weapons.visibility = View.VISIBLE
                    binding.loader.root.visibility = View.GONE
                    binding.errorText.visibility = View.GONE
                    weaponsAdapter.submitList(newValue.value)
                }
                is OutputOf.Error.NotFoundError -> {
                    binding.weapons.visibility = View.GONE
                    binding.loader.root.visibility = View.GONE
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = getString(R.string.not_found)
                }
                is OutputOf.Error -> {
                    binding.weapons.visibility = View.GONE
                    binding.loader.root.visibility = View.GONE
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = newValue.message
                }
                is OutputOf.Loader -> {
                    binding.weapons.visibility = View.GONE
                    binding.loader.root.visibility = View.VISIBLE
                    binding.errorText.visibility = View.GONE
                }
                else -> {

                }
            }
        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
    }

    private fun initSearchBar() {
        this.searchView?.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(value: String): Boolean {
                searchView?.clearFocus()
                return false
            }

            override fun onQueryTextChange(value: String): Boolean {
                viewModel.filterWeaponsByName(value)
                return false
            }
        })
    }

    override fun onDestroy() {
        searchView?.clearFocus()
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