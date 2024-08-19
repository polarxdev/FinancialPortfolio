package com.example.financialportfolio.presentation.settings.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.financialportfolio.databinding.FragmentBottomsheetBinding
import com.example.financialportfolio.presentation.settings.SettingsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsBottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentBottomsheetBinding? = null
    private val binding get() = _binding!!
    private val settingsViewModel: SettingsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomsheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingsViewModel.getSettingsList()
        settingsViewModel.settingsList.observe(
            viewLifecycleOwner
        ) { list ->
            val itemAdapter = SettingsBottomSheetListAdapter(list) { currency ->
                settingsViewModel.saveCurrency(currency)
                dismiss()
            }
            binding.bottomsheetRv.adapter = itemAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
