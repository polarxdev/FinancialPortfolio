package com.example.financialportfolio.presentation.settings.bottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.ItemSettingsBinding

class BottomSheetListAdapter(
    private var list: List<String>,
    private val onItemClicked: (String) -> Unit
) : RecyclerView.Adapter<BottomSheetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetViewHolder {
        val binding = ItemSettingsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BottomSheetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BottomSheetViewHolder, position: Int) {
        holder.bind(position, list, onItemClicked)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
