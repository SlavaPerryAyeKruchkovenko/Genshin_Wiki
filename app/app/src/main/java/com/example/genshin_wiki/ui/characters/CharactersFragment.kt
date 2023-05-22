package com.example.genshin_wiki.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.genshin_wiki.R
import com.example.genshin_wiki.adapters.CharacterAdapter
import com.example.genshin_wiki.databinding.CharacterProfileBinding
import com.example.genshin_wiki.databinding.FragmentCharatersBinding
import com.example.genshin_wiki.models.CharacterProfile

class CharactersFragment : Fragment() {
    private var _binding: FragmentCharatersBinding? = null
    private val binding get() = _binding!!
    private val characterAdapter = CharacterAdapter()
    private val viewModel = CharactersViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharatersBinding.inflate(inflater, container, false)
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
        val observer = Observer<List<CharacterProfile>> { newValue ->
            characterAdapter.submitList(newValue)
        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
    }
}