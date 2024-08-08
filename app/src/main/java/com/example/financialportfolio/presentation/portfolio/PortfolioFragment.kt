package com.example.financialportfolio.presentation.portfolio

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentPortfolioBinding
import com.example.financialportfolio.presentation.common.rv.AdapterDelegatesManager
import com.example.financialportfolio.presentation.portfolio.rv.PortfolioAssetDelegate
import com.example.financialportfolio.presentation.portfolio.rv.PortfolioAssetListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PortfolioFragment : Fragment(R.layout.fragment_portfolio) {

    private var _binding: FragmentPortfolioBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PortfolioViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPortfolioBinding.bind(view)

        val adapter = PortfolioAssetListAdapter(
            items = listOf(),
            delegatesManager = AdapterDelegatesManager(
                PortfolioAssetDelegate { model, menuItem ->
                    when (menuItem.itemId) {
                        R.id.action_delete -> {
                            viewModel.deletePortfolioAsset(model.id.toInt())
                        }
                    }
                }
            )
        )

        binding.portfolioAssetList.adapter = adapter

        viewModel.portfolioAssetList.observe(viewLifecycleOwner) { portfolioAssets ->
            portfolioAssets?.let {
                adapter.submitItems(portfolioAssets)
            }
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
