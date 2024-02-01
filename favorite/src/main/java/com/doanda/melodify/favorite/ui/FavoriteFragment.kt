package com.doanda.melodify.favorite.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.doanda.melodify.core.domain.model.Track
import com.doanda.melodify.core.ui.FavoriteAdapter
import com.doanda.melodify.favorite.databinding.FragmentFavoriteBinding
import com.doanda.melodify.favorite.koin.favoriteModule
import com.doanda.melodify.ui.track.TrackActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteFragment : Fragment() {

    private val binding by lazy { FragmentFavoriteBinding.inflate(layoutInflater) }

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadKoinModules(favoriteModule)

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
                favoriteAdapter.submitList(trackList)
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