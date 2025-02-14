package com.alfsuace.expmdmfebrero.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfsuace.expmdmfebrero.R
import com.alfsuace.expmdmfebrero.data.AlbumDataRepository
import com.alfsuace.expmdmfebrero.data.local.AlbumLocalDataRepository
import com.alfsuace.expmdmfebrero.data.local.AlbumMock
import com.alfsuace.expmdmfebrero.databinding.FragmentAlbumListBinding
import com.alfsuace.expmdmfebrero.domain.GetAlbumsUseCase
import com.alfsuace.expmdmfebrero.presentation.adapter.AlbumAdapter

class AlbumListFragment : Fragment(R.layout.fragment_album_list) {

    private var _binding: FragmentAlbumListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AlbumListViewModel by lazy {
        AlbumListViewModel(
            GetAlbumsUseCase(
                AlbumDataRepository(
                    AlbumLocalDataRepository(requireContext())
                )
            )
        )
    }

    private lateinit var adapter: AlbumAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlbumListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AlbumAdapter(
            onClick = { navigateToDetail(it.id) },
            onFavoriteClick = { viewModel.clickedFavorite(it) }
        )
        setUpRecyclerView()
        setUpObserver()
        viewModel.loadAlbums()
        binding.toolbarAlbum.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_bookmark -> {
                    viewModel.toggleShowFavorites()
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateToDetail(id: String) {
        findNavController().navigate(AlbumListFragmentDirections.actionAlbumListFragmentToStickerListFragment(id))
    }

    private fun setUpRecyclerView() {
        binding.albumList.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.albumList.adapter = adapter
    }

    private fun setUpObserver(){
        val observer = Observer<AlbumListViewModel.UiState>{
            if (it.loading) {
                Log.d("@dev", "Cargando datos...")
            }
            if (it.error) {
                Log.d("@dev", "Ocurrió un error al cargar los datos")
            }
            adapter.submitList(it.albums)
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
