package ru.spiridonov.amusic.presentation.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.spiridonov.amusic.AMusicApp
import ru.spiridonov.amusic.databinding.FragmentHomeBinding
import ru.spiridonov.amusic.presentation.ViewModelFactory
import ru.spiridonov.amusic.presentation.adapters.TrackAdapter
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding is null")

    private val component by lazy {
        (requireActivity().application as AMusicApp).component
    }

    private val trackAdapter by lazy {
        TrackAdapter()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: HomeViewModel

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        binding.rvTracks.adapter = trackAdapter
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getChartTrackList().observe(viewLifecycleOwner) {
            trackAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}