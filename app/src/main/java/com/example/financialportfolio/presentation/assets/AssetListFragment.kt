package com.example.financialportfolio.presentation.assets

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentAssetsListBinding
import com.example.financialportfolio.presentation.assets.rv.AssetListAdapter
import com.example.financialportfolio.presentation.assets.rv.BondDelegate
import com.example.financialportfolio.presentation.assets.rv.CashDelegate
import com.example.financialportfolio.presentation.assets.rv.StockDelegate
import com.example.financialportfolio.presentation.common.rv.AdapterDelegatesManager
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
                CashDelegate {
                    findNavController().navigate(
                        AssetListFragmentDirections
                            .actionAssetsListFragmentToAssetDetailFragment(it.id)
                    )
                },
                BondDelegate {
                    findNavController().navigate(
                        AssetListFragmentDirections
                            .actionAssetsListFragmentToAssetDetailFragment(it.id)
                    )
                },
                StockDelegate {
                    findNavController().navigate(
                        AssetListFragmentDirections
                            .actionAssetsListFragmentToAssetDetailFragment(it.id)
                    )
                }
            )
        )

        recyclerView.adapter = adapter

        viewModel.assetList.observe(viewLifecycleOwner) { assets ->
            assets?.let { adapter.submitItems(assets) }
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
