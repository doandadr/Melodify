package com.doanda.melodify.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.doanda.melodify.MyApplication
import com.doanda.melodify.core.data.Resource
import com.doanda.melodify.core.domain.model.Track
import com.doanda.melodify.databinding.FragmentHomeBinding
import com.doanda.melodify.ui.ViewModelFactory
import com.doanda.melodify.ui.track.TrackActivity
import javax.inject.Inject

class HomeFragment : Fragment() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: HomeViewModel by viewModels { factory }

    private lateinit var trackAdapter: TrackAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
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
        viewModel.tracks.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Loading -> showLoading(true)
                is Resource.Success -> {
                    showLoading(false)
                    trackAdapter.submitList(result.data)
                }
                is Resource.Error -> {
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