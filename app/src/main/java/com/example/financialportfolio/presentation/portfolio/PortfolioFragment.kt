package com.example.financialportfolio.presentation.portfolio

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentPortfolioBinding

class PortfolioFragment : Fragment(R.layout.fragment_portfolio) {

    private var _binding: FragmentPortfolioBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentPortfolioBinding.bind(view)
        binding.comebackButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
