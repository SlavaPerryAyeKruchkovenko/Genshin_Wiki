package com.example.genshin_wiki.ui.artifacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.genshin_wiki.adapters.ArtifactAdapter
import com.example.genshin_wiki.databinding.FragmentArtifactsBinding
import com.example.genshin_wiki.models.Artifact

class ArtifactsFragment : Fragment() {
    private var _binding: FragmentArtifactsBinding? = null
    private val binding get() = _binding!!
    private val characterAdapter = ArtifactAdapter()
    private val viewModel = ArtifactViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArtifactsBinding.inflate(inflater, container, false)
        init()
        viewModel.init()
        return binding.root
    }

    private fun init() {
        binding.artifacts.layoutManager = GridLayoutManager(
            context,
            2
        )
        binding.artifacts.adapter = characterAdapter
        val observer = Observer<List<Artifact>> { newValue ->
            characterAdapter.submitList(newValue)
        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}