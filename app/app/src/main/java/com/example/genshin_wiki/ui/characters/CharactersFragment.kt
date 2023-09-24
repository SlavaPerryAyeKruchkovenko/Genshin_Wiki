package com.example.genshin_wiki.ui.characters

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
import com.example.genshin_wiki.adapters.CharacterAdapter
import com.example.genshin_wiki.data.models.Character
import com.example.genshin_wiki.data.models.OutputOf
import com.example.genshin_wiki.databinding.FragmentCharactersBinding
import com.example.genshin_wiki.interfaces.listeners.CharacterListener
import org.koin.androidx.viewmodel.ext.android.getViewModel

class CharactersFragment : Fragment(), CharacterListener {
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!
    private val characterAdapter = CharacterAdapter(this)
    private val viewModel by lazy { getViewModel<CharactersViewModel>() }
    private var searchView: SearchView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        searchView = binding.searchAppbar.searchBar
        init()
        viewModel.init()
        return binding.root
    }

    private fun init() {
        /*(activity?.application as ToolsApp).component.inject(this)*/
        initCharactersRecycle()
        initSearchBar()
    }

    private fun initCharactersRecycle() {
        binding.characters.layoutManager = GridLayoutManager(
            context,
            2
        )
        binding.characters.adapter = characterAdapter
        val observer = Observer<OutputOf<List<Character>>> { newValue ->
            when (newValue) {
                is OutputOf.Success -> {
                    binding.characters.visibility = View.VISIBLE
                    binding.loader.root.visibility = View.GONE
                    binding.errorText.visibility = View.GONE
                    characterAdapter.submitList(newValue.value)
                }
                is OutputOf.Error.NotFoundError -> {
                    binding.characters.visibility = View.GONE
                    binding.loader.root.visibility = View.GONE
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = getString(R.string.not_found)
                }
                is OutputOf.Error -> {
                    binding.characters.visibility = View.GONE
                    binding.loader.root.visibility = View.GONE
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = newValue.message
                }
                is OutputOf.Loader -> {
                    binding.characters.visibility = View.GONE
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
                viewModel.filterCharactersByName(value)
                return false
            }
        })
    }

    override fun onClick(profile: Character) {
        val bundle = Bundle()
        bundle.apply {
            putString("character_id", profile.id)
        }
        findNavController().navigate(R.id.action_characters_to_character_portrait, bundle)
    }

    override fun onDestroy() {
        searchView?.clearFocus()
        super.onDestroy()
        _binding = null
    }
}