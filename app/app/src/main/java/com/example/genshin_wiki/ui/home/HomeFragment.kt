package com.example.genshin_wiki.ui.home

import android.content.res.ColorStateList
import android.icu.util.Calendar
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.genshin_wiki.R
import com.example.genshin_wiki.adapters.DungeonAdapter
import com.example.genshin_wiki.data.models.DungeonResource
import com.example.genshin_wiki.data.models.enums.Day
import com.example.genshin_wiki.databinding.FragmentHomeBinding
import com.example.genshin_wiki.layouts.DungeonLayout
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()
    private val dungeonAdapter = DungeonAdapter()
    private var canScroll = true
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
        initDayOfWeek()
        initDungeonView()
        initPitchView()
        initAdapterBtn()
        initAppBar()
    }
    private fun initAppBar() {
        binding.homeAppbar.toolBar.setOnMenuItemClickListener {
            when (it?.itemId) {
                R.id.filter -> {
                    findNavController().navigate(R.id.action_home_to_liked)
                    true
                }
                else -> false
            }
        }
    }

    private fun initDayOfWeek() {
        val calendar = Calendar.getInstance()
        val dayOfWeek = Day.values()[calendar.get(Calendar.DAY_OF_WEEK) - 1]

        val dayObserver = Observer<Day> { newValue ->
            viewModel.initDungeonResource(newValue)
            binding.dayOfWeek.text = getString(newValue.value)
        }
        viewModel.dayOfWeekData.observe(viewLifecycleOwner, dayObserver)
        viewModel.setCurrentDay(dayOfWeek)
    }

    private fun initDungeonView() {

        val dungeonRecycle = binding.resources
        val scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                try {
                    if (dy == 0 && canScroll) {
                        val position =
                            (recyclerView.layoutManager as DungeonLayout).findFirstVisibleItemPosition()
                        viewModel.changeAdapterPosition(position / 2)
                    }
                } catch (_: Exception) {
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == 0 && !canScroll) {
                    canScroll = true
                }
            }
        }
        dungeonRecycle.apply {
            layoutManager = DungeonLayout(context)
            adapter = dungeonAdapter
            addOnScrollListener(scrollListener)
            isNestedScrollingEnabled = false
        }
        val dungeonObserver = Observer<List<DungeonResource>> { newValue ->
            dungeonAdapter.submitList(newValue)
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
        val dungeonRecycle = binding.resources
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
            dungeonRecycle.smoothScrollToPosition(newValue * 2)
            when (newValue) {
                0 -> changePosition(mondstadt)
                1 -> changePosition(liYue)
                2 -> changePosition(inadzuma)
                3 -> changePosition(sumeru)
                else -> changePosition(mondstadt)
            }
        }
        mondstadt.setOnClickListener {
            viewModel.changeAdapterPosition(0)
            canScroll = false
        }
        liYue.setOnClickListener {
            viewModel.changeAdapterPosition(1)
            canScroll = false
        }
        inadzuma.setOnClickListener {
            viewModel.changeAdapterPosition(2)
            canScroll = false
        }
        sumeru.setOnClickListener {
            viewModel.changeAdapterPosition(3)
            canScroll = false
        }
        viewModel.adapterPositionData.observe(viewLifecycleOwner, positionObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}