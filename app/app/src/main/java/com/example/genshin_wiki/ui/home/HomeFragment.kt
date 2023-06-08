package com.example.genshin_wiki.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.genshin_wiki.adapters.DungeonAdapter
import com.example.genshin_wiki.databinding.FragmentHomeBinding
import com.example.genshin_wiki.models.DungeonResource

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel = HomeViewModel()
    private val adapter = DungeonAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        viewModel.init()
        return binding.root
    }

    private fun init() {
        binding.resources.layoutManager = GridLayoutManager(
            context,
            2,
            GridLayoutManager.HORIZONTAL,
            false
        )
        binding.resources.adapter = adapter
        val observer = Observer<List<DungeonResource>> { newValue ->
            adapter.submitList(newValue)
        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
    }
}