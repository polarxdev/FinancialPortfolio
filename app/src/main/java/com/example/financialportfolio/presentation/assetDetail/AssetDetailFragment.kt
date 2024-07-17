package com.example.financialportfolio.presentation.assetDetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentAssetDetailBinding
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.entity.Bond
import com.example.financialportfolio.domain.entity.Cash
import com.example.financialportfolio.domain.entity.Stock

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssetDetailFragment : Fragment(R.layout.fragment_asset_detail) {
    private var _binding: FragmentAssetDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AssetDetailViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentAssetDetailBinding.bind(view)

        val args: AssetDetailFragmentArgs by navArgs()
        val id = args.Id

        viewModel.model.observe(viewLifecycleOwner) { assets ->
            var asset = assets.get(id.dec())

            bindInfo(asset)
        }

        binding.backIcon.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    fun bindInfo(model: Asset){
        with(binding){
            name.text = model.name
            countryValue.text = model.meta.country
            sectorValue.text = model.meta.sector
            when(model){
                is Cash -> {
                    valueType.setText(R.string.currency)
                    value.text = model.currency
                }
                is Bond -> {
                    valueType.setText(R.string.maturity_date)
                    value.text = model.maturityDate.toString()
                }
                is Stock -> {
                    valueType.setText(R.string.ticker)
                    value.text = model.ticker
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
