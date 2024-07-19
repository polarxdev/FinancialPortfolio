package com.example.financialportfolio.presentation.portfolio

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentPortfolioBinding
import com.example.financialportfolio.presentation.rv.PortfolioAssetListAdapter
import com.example.financialportfolio.presentation.rv.delegate.AdapterDelegatesManager
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
                PortfolioAssetListItemAdapterDelegate { model, menuItem ->
                    when (menuItem.itemId) {
                        R.id.action_delete -> {
                            viewModel.deletePortfolioAsset(model)
                        }
                    }
                }
            )
        )

        recyclerView.adapter = adapter

        viewModel.model.observe(viewLifecycleOwner) { assets ->
            assets?.let {
                adapter.submitItems(it)
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
