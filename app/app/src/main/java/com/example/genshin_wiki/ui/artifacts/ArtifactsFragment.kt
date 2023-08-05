package com.example.genshin_wiki.ui.artifacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.genshin_wiki.R
import com.example.genshin_wiki.adapters.ArtifactAdapter
import com.example.genshin_wiki.data.models.Artifact
import com.example.genshin_wiki.data.models.OutputOf
import com.example.genshin_wiki.databinding.FragmentArtifactsBinding
import com.example.genshin_wiki.interfaces.listeners.ArtifactListener

class ArtifactsFragment : Fragment(), ArtifactListener {
    private var _binding: FragmentArtifactsBinding? = null
    private val binding get() = _binding!!
    private val characterAdapter = ArtifactAdapter(this)
    private val viewModel by viewModels<ArtifactViewModel>()
    private var searchView: SearchView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArtifactsBinding.inflate(inflater, container, false)
        searchView = binding.searchAppbar.searchBar
        init()
        viewModel.init()
        return binding.root
    }

    private fun init() {
        initArtifactRecycle()
        initSearchBar()
    }

    private fun initArtifactRecycle() {
        binding.artifacts.layoutManager = GridLayoutManager(
            context,
            2
        )
        binding.artifacts.adapter = characterAdapter
        val observer = Observer<OutputOf<List<Artifact>>> { newValue ->
            when(newValue){
                is OutputOf.Success -> {
                    binding.artifacts.visibility = View.VISIBLE
                    binding.loader.root.visibility = View.GONE
                    binding.errorText.visibility = View.GONE
                    characterAdapter.submitList(newValue.value)
                }
                is OutputOf.Error.NotFoundError -> {
                    binding.artifacts.visibility = View.GONE
                    binding.loader.root.visibility = View.GONE
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = getString(R.string.not_found)
                }
                is OutputOf.Error -> {
                    binding.artifacts.visibility = View.GONE
                    binding.loader.root.visibility = View.GONE
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = newValue.message
                }
                is OutputOf.Loader -> {
                    binding.artifacts.visibility = View.GONE
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
                viewModel.filterArtifactsByName(value)
                return false
            }
        })
    }

    override fun onDestroy() {
        searchView?.clearFocus()
        super.onDestroy()
        _binding = null
    }

    override fun onClick(profile: Artifact) {
        val bundle = Bundle()
        bundle.apply {
            putString("artifact_id", profile.id)
        }
        findNavController().navigate(R.id.action_artifacts_to_artifact_portrait, bundle)
    }
}