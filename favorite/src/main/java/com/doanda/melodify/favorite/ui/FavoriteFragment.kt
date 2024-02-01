package com.doanda.melodify.favorite.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.doanda.melodify.core.domain.model.Track
import com.doanda.melodify.core.ui.FavoriteAdapter
import com.doanda.melodify.favorite.ViewModelFactory
import com.doanda.melodify.favorite.databinding.FragmentFavoriteBinding
import com.doanda.melodify.ui.track.TrackActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//@AndroidEntryPoint
class FavoriteFragment : Fragment() {

//    private val binding by lazy { FragmentFavoriteBinding.inflate(layoutInflater) }
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

//    private val favoriteViewModel: FavoriteViewModel by viewModels()
    @Inject
    lateinit var factory: ViewModelFactory
    private val favoriteViewModel: FavoriteViewModel by viewModels { factory }

    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteAdapter = FavoriteAdapter()
        favoriteAdapter.setOnItemClickCallback(object : FavoriteAdapter.OnItemClickCallback {
            override fun onItemClicked(track: Track) {
                launchTrackActivity(track)
            }
        })

        setupRecyclerView()
        observeFavoriteTracksData()
    }

    private fun launchTrackActivity(track: Track) {
        val intent = Intent(requireContext(), TrackActivity::class.java)
        intent.putExtra(TrackActivity.EXTRA_TRACK, track)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        binding.rvFavoriteTracks.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = favoriteAdapter
        }
    }

    private fun observeFavoriteTracksData() {
        favoriteViewModel.favoriteTracks.observe(viewLifecycleOwner) { trackList ->
            if (trackList.isNullOrEmpty()) {
                showEmpty(true)
            } else {
                favoriteAdapter.submitList(trackList)
            }
        }
    }

    private fun showEmpty(isEmpty: Boolean) {
        if (isEmpty) binding.tvFavorite.text = "No Data"
    }
}