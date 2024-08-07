package com.example.financialportfolio.presentation.settings

import SettingsViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.FragmentSettingsBinding
import com.example.financialportfolio.presentation.settings.bottomsheet.BottomSheetFragment
import kotlinx.coroutines.launch

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val settingsViewModel: SettingsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSettingsBinding.bind(view)

        lifecycleScope.launch {
            settingsViewModel.readCurrencyFromPreferences().collect { currency ->
                binding.currencyTv.text = currency
            }
        }

        binding.changeBtn.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
        }

        binding.backIcon.setOnClickListener {
            findNavController().navigateUp()
        }

        settingsViewModel.selectedCurrency.observe(viewLifecycleOwner) { currency ->
            binding.currencyTv.text = currency
            lifecycleScope.launch {
                settingsViewModel.saveCurrencyToPreferences(currency)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
