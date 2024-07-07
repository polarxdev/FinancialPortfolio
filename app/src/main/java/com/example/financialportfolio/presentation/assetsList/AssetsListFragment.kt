package com.example.financialportfolio.presentation.assetsList

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentAssetsListBinding
import com.example.financialportfolio.presentation.rv.AssetListAdapter
import kotlin.math.log

class AssetsListFragment : Fragment(R.layout.fragment_assets_list) {

    private var fragmentAssetsListBinding: FragmentAssetsListBinding? = null
    private val viewModel: AssetsListViewModel by viewModels()

    private lateinit var adapter: AssetListAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAssetsListBinding.bind(view)
        fragmentAssetsListBinding = binding

        recyclerView = binding.assetsList
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = AssetListAdapter {
            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter

        viewModel.model.observe(viewLifecycleOwner) { assets ->
            adapter.submitItems(assets)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentAssetsListBinding = null
    }
}
