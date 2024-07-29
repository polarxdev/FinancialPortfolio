package com.example.financialportfolio.presentation.settings.bottomsheet

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.databinding.ItemSettingsBinding

class BottomSheetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemSettingsBinding = ItemSettingsBinding.bind(itemView)

    val item: TextView = binding.currencyName
}
