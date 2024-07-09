package com.example.financialportfolio.presentation.assetList

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentAssetsListBinding
import com.example.financialportfolio.presentation.rv.AssetListAdapter
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
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = AssetListAdapter {
            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter

        viewModel.model.observe(viewLifecycleOwner) { assets ->
            adapter.submitItems(assets)
        }

        binding.comebackButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
