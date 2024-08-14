package com.example.financialportfolio.presentation.settings.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.financialportfolio.databinding.FragmentBottomsheetBinding
import com.example.financialportfolio.presentation.settings.SettingsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment(private val settingsViewModel: SettingsViewModel) :
    BottomSheetDialogFragment() {
    private var _binding: FragmentBottomsheetBinding? = null
    private val binding get() = _binding!!
    private val list = settingsViewModel.getSettingsList()

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

        val itemAdapter = BottomSheetListAdapter(list) { currency ->
            settingsViewModel.selectCurrency(currency)
            dismiss()
        }
        val recyclerView = binding.bottomsheetRv
        recyclerView.adapter = itemAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
