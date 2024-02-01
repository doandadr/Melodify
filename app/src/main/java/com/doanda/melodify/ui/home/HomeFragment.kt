package com.doanda.melodify.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.doanda.melodify.core.domain.model.Track
import com.doanda.melodify.core.ui.TrackAdapter
import com.doanda.melodify.databinding.FragmentHomeBinding
import com.doanda.melodify.ui.track.TrackActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

//    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var trackAdapter: TrackAdapter

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

        trackAdapter = TrackAdapter()
        trackAdapter.setOnItemClickCallback(object : TrackAdapter.OnItemClickCallback {
            override fun onItemClicked(track: Track) {
                launchTrackActivity(track)
            }
        })

        setupRecyclerView()
        observeTrackData()

    }

    private fun launchTrackActivity(track: Track) {
        val intent = Intent(requireContext(), TrackActivity::class.java)
        intent.putExtra(TrackActivity.EXTRA_TRACK, track)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        binding.rvTracks.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = trackAdapter
        }
    }

    private fun observeTrackData() {
        homeViewModel.tracks.observe(viewLifecycleOwner) { result ->
            when (result) {
                is com.doanda.melodify.core.data.Resource.Loading -> showLoading(true)
                is com.doanda.melodify.core.data.Resource.Success -> {
                    showLoading(false)
                    trackAdapter.submitList(result.data)
                }
                is com.doanda.melodify.core.data.Resource.Error -> {
                    showLoading(false)
                    val description = "Failed to connect to network :("
                    Log.e("Home", result.message + description)
                    Toast.makeText(requireContext(), description, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}