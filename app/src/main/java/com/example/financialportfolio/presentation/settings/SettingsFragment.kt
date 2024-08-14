package com.example.financialportfolio.presentation.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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
    private val settingsViewModel: SettingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSettingsBinding.bind(view)

        settingsViewModel.selectedCurrency.observe(viewLifecycleOwner) { currency ->
            binding.currencyTv.text = currency
        }

        settingsViewModel.readCurrencyFromPreferences(requireContext())

        binding.changeBtn.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment(settingsViewModel)
            bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
        }

        binding.backIcon.setOnClickListener {
            findNavController().navigateUp()
        }

        settingsViewModel.selectedCurrency.observe(viewLifecycleOwner) { currency ->
            binding.currencyTv.text = currency
            settingsViewModel.saveCurrencyToPreferences(currency, requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
