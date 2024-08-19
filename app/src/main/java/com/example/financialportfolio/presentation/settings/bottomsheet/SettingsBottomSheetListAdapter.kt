package com.example.financialportfolio.presentation.settings.bottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.databinding.ItemSettingsBinding

class SettingsBottomSheetListAdapter(
    private var list: List<String>,
    private val onItemClicked: (String) -> Unit
) : RecyclerView.Adapter<SettingsBottomSheetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsBottomSheetViewHolder {
        val binding = ItemSettingsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return SettingsBottomSheetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SettingsBottomSheetViewHolder, position: Int) {
        holder.bind(position, list, onItemClicked)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
