package com.example.financialportfolio.presentation.settings.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.databinding.FragmentBottomsheetBinding
import com.example.financialportfolio.presentation.settings.SettingsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomsheetBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemAdapter: BottomSheetListAdapter
    private lateinit var recyclerView: RecyclerView
    private var list = ArrayList<String>()
    private val settingsViewModel: SettingsViewModel by activityViewModels()

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

        list = arrayListOf("BYN", "CNY", "RUB", "EUR", "USD")

        itemAdapter = BottomSheetListAdapter(list, requireContext()) { currency ->
            settingsViewModel.selectCurrency(currency)
            dismiss()
        }
        recyclerView = binding.bottomsheetRv
        recyclerView.adapter = itemAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
