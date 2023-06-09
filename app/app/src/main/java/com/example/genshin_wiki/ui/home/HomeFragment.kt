package com.example.genshin_wiki.ui.home

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.genshin_wiki.R
import com.example.genshin_wiki.adapters.DungeonAdapter
import com.example.genshin_wiki.databinding.FragmentHomeBinding
import com.example.genshin_wiki.models.DungeonResource
import com.google.android.material.button.MaterialButton

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
        initDungeonView()
        initPitchView()
        initAdapterBtn()
    }

    private fun initDungeonView() {
        val dungeonObserver = Observer<List<DungeonResource>> { newValue ->
            adapter.submitList(newValue)
        }
        viewModel.liveData.observe(viewLifecycleOwner, dungeonObserver)
    }

    private fun initPitchView() {
        val pitchBtn = binding.reset
        val pitchObserver = Observer<Int> { newValue ->
            binding.value.text = newValue.toString()
        }

        pitchBtn.setOnClickListener {
            viewModel.resetPitch()
        }
        viewModel.pitchData.observe(viewLifecycleOwner, pitchObserver)
    }

    private fun initAdapterBtn() {
        val mondstadt = binding.mondstadt
        val liYue = binding.liYue
        val inadzuma = binding.inadzuma
        val sumeru = binding.sumeru
        val adapterBtns = listOf(mondstadt, liYue, inadzuma, sumeru)

        fun changePosition(btn: MaterialButton) {
            fun changeColor(materialButton: MaterialButton, attr: Int) {
                val typedValue = TypedValue()
                requireContext().theme.resolveAttribute(attr, typedValue, true)
                val color = typedValue.data
                materialButton.backgroundTintList = ColorStateList.valueOf(color)
            }
            adapterBtns.forEach {
                changeColor(it, R.attr.colorOnPrimary)
            }
            changeColor(btn, R.attr.colorOnPrimarySurface)
        }

        val positionObserver = Observer<Int> { newValue ->
            when (newValue) {
                0 -> changePosition(mondstadt)
                1 -> changePosition(liYue)
                2 -> changePosition(inadzuma)
                3 -> changePosition(sumeru)
                else -> changePosition(mondstadt)
            }
        }
        mondstadt.setOnClickListener { viewModel.changeAdapterPosition(0) }
        liYue.setOnClickListener { viewModel.changeAdapterPosition(1) }
        inadzuma.setOnClickListener { viewModel.changeAdapterPosition(2) }
        sumeru.setOnClickListener { viewModel.changeAdapterPosition(3) }
        viewModel.adapterPositionData.observe(viewLifecycleOwner, positionObserver)
    }
}