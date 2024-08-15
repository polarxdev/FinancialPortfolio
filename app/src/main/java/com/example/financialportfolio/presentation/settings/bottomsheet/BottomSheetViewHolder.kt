package com.example.financialportfolio.presentation.settings.bottomsheet

import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.databinding.ItemSettingsBinding

class BottomSheetViewHolder(
    private val binding: ItemSettingsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(position: Int, list: List<String>, onItemClicked: (String) -> Unit) {
        val item = list[position]
        binding.currencyName.text = item
        binding.root.setOnClickListener { onItemClicked(item) }
    }
}
