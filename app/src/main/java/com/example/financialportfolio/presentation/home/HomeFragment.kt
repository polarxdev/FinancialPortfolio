package com.example.financialportfolio.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)
        with(binding) {
            toAssetsListButton.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAssetsListFragment())
            }
            toPortfolioButton.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPortfolioFragment())
            }
            toSettingsButton.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSettingsFragment())
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}