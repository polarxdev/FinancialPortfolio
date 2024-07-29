package com.example.financialportfolio.presentation.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentSettingsBinding
import com.example.financialportfolio.presentation.settings.bottomsheet.BottomSheetFragment

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedPreferences: SharedPreferences
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSettingsBinding.bind(view)

        sharedPreferences = requireContext()
            .getSharedPreferences("Settings", Context.MODE_PRIVATE)

        binding.currencyTv.text = sharedPreferences.getString("currency", "BYN")

        binding.changeBtn.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
        }

        binding.backIcon.setOnClickListener {
            findNavController().navigateUp()
        }

        sharedViewModel.selectedCurrency.observe(viewLifecycleOwner) { currency ->
            binding.currencyTv.text = currency
            saveCurrencyToPreferences(currency)
        }
    }

    private fun saveCurrencyToPreferences(currency: String) {
        sharedPreferences.edit().apply {
            putString("currency", currency)
            apply()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
