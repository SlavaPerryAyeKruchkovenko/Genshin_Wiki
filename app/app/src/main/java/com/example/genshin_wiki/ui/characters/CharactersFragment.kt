package com.example.genshin_wiki.ui.characters

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
import com.example.genshin_wiki.adapters.CharacterAdapter
import com.example.genshin_wiki.databinding.FragmentCharactersBinding
import com.example.genshin_wiki.interfaces.listeners.CharacterListener
import com.example.genshin_wiki.data.models.Character
import com.example.genshin_wiki.ui.weapons.WeaponsViewModel

class CharactersFragment : Fragment(), CharacterListener {
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!
    private val characterAdapter = CharacterAdapter(this)
    private val viewModel by viewModels<CharactersViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        init()
        viewModel.init()
        return binding.root
    }
    private fun init(){
        /*(activity?.application as ToolsApp).component.inject(this)*/
        binding.characters.layoutManager = GridLayoutManager(
            context,
            2
        )
        binding.characters.adapter = characterAdapter
        val observer = Observer<List<Character>> { newValue ->
            characterAdapter.submitList(newValue)
        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
    }

    override fun onClick(profile: Character) {
        val bundle = Bundle()
        bundle.apply {
            putString("character_id", profile.id)
        }
        findNavController().navigate(R.id.action_characters_to_character_portrait, bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}