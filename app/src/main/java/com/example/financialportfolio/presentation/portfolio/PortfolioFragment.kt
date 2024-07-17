package com.example.financialportfolio.presentation.portfolio

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentPortfolioBinding
import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.presentation.rv.AssetListAdapter
import com.example.financialportfolio.presentation.rv.PortfolioAssetListAdapter
import com.example.financialportfolio.presentation.rv.delegate.AdapterDelegatesManager
import com.example.financialportfolio.presentation.rv.delegate.AssetBondListItemAdapterDelegate
import com.example.financialportfolio.presentation.rv.delegate.AssetCashListItemAdapterDelegate
import com.example.financialportfolio.presentation.rv.delegate.AssetStockListItemAdapterDelegate
import com.example.financialportfolio.presentation.rv.delegate.PortfolioAssetListItemAdapterDelegate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PortfolioFragment : Fragment(R.layout.fragment_portfolio) {

    private var _binding: FragmentPortfolioBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PortfolioViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentPortfolioBinding.bind(view)

        val recyclerView = binding.portfolioAssetList
        val adapter = PortfolioAssetListAdapter(
            items = listOf(),
            delegatesManager = AdapterDelegatesManager(
            PortfolioAssetListItemAdapterDelegate{
                Toast.makeText(context, "Portfolio item clicked", Toast.LENGTH_SHORT).show()
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
        val asset = viewModel.getPortfolioAssetById(id=1)

        binding.toolbar.setOnClickListener{
            Toast.makeText(context, "Asset clicked ${asset.value?.id ?: "ASDf"}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
