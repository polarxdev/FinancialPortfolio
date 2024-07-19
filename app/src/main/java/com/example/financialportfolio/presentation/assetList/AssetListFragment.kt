package com.example.financialportfolio.presentation.assetList

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentAssetsListBinding
import com.example.financialportfolio.presentation.rv.AssetListAdapter
import com.example.financialportfolio.presentation.rv.delegate.AdapterDelegatesManager
import com.example.financialportfolio.presentation.rv.delegate.AssetBondListItemAdapterDelegate
import com.example.financialportfolio.presentation.rv.delegate.AssetCashListItemAdapterDelegate
import com.example.financialportfolio.presentation.rv.delegate.AssetStockListItemAdapterDelegate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssetListFragment : Fragment(R.layout.fragment_assets_list) {

    private var _binding: FragmentAssetsListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AssetListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentAssetsListBinding.bind(view)

        val recyclerView = binding.assetsList
        val adapter = AssetListAdapter(
            items = listOf(),
            delegatesManager = AdapterDelegatesManager(
                AssetCashListItemAdapterDelegate {
                    findNavController().navigate(
                        AssetListFragmentDirections
                            .actionAssetsListFragmentToAssetDetailFragment(it.id)
                    )
                },
                AssetBondListItemAdapterDelegate {
                    findNavController().navigate(
                        AssetListFragmentDirections
                            .actionAssetsListFragmentToAssetDetailFragment(it.id)
                    )
                },
                AssetStockListItemAdapterDelegate {
                    findNavController().navigate(
                        AssetListFragmentDirections
                            .actionAssetsListFragmentToAssetDetailFragment(it.id)
                    )
                }
            )
        )

        recyclerView.adapter = adapter

        viewModel.model.observe(viewLifecycleOwner) { assets ->
            adapter.submitItems(assets)
        }

        binding.backIcon.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
