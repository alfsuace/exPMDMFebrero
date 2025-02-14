package com.alfsuace.expmdmfebrero.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfsuace.expmdmfebrero.R
import com.alfsuace.expmdmfebrero.data.AlbumDataRepository
import com.alfsuace.expmdmfebrero.data.local.AlbumLocalDataRepository
import com.alfsuace.expmdmfebrero.databinding.FragmentDetailAlbumBinding
import com.alfsuace.expmdmfebrero.domain.GetAlbumByIdUseCase
import com.alfsuace.expmdmfebrero.presentation.adaptersticker.MushroomAdapter

class StickerListFragment():Fragment() {
    private var _binding: FragmentDetailAlbumBinding? = null
    private val binding get() = _binding!!

    private val args: StickerListFragmentArgs by navArgs()

    private val viewModel: StickerListViewModel by lazy {
        StickerListViewModel(
            GetAlbumByIdUseCase(
                AlbumDataRepository(
                    AlbumLocalDataRepository(requireContext())
                )
            )
        )
    }

    private lateinit var adapter: MushroomAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MushroomAdapter()
        setUpToolBar()
        setUpRecyclerView()
        setUpObserver()
        viewModel.loadAlbum(args.id.toString())
    }

    private fun setUpToolBar() {

        binding.toolbar.toolbar.apply {
            setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun setUpRecyclerView() {
        binding.stickerList.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.stickerList.adapter = adapter
    }

    private fun setUpObserver(){
        val observer = Observer<StickerListViewModel.UiState>{
            adapter.submitList(it.album?.mushrooms)
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}