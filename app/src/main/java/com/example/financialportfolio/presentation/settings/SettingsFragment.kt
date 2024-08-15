package com.example.financialportfolio.presentation.settings

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentSettingsBinding
import com.example.financialportfolio.presentation.settings.bottomsheet.BottomSheetFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val settingsViewModel: SettingsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSettingsBinding.bind(view)

        settingsViewModel.savedCurrency.observe(viewLifecycleOwner) { currency ->
            binding.currencyTv.text = currency
        }

        settingsViewModel.readCurrencyFromPreferences()

        binding.changeBtn.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(childFragmentManager, BottomSheetFragment.TAG)
        }

        binding.backIcon.setOnClickListener {
            findNavController().navigateUp()
        }

        settingsViewModel.selectedCurrency.observe(viewLifecycleOwner) { currency ->
            binding.currencyTv.text = currency
            settingsViewModel.saveCurrencyToPreferences(currency)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
