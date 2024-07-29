package com.example.financialportfolio.presentation.settings.bottomsheet

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.R

class BottomSheetListAdapter(
    private var list: ArrayList<String>,
    private val context: Context,
    private val onItemClicked: (String) -> Unit
) : RecyclerView.Adapter<BottomSheetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_settings, parent, false)
        return BottomSheetViewHolder(view)
    }

    override fun onBindViewHolder(holder: BottomSheetViewHolder, position: Int) {
        val item = list[position]
        holder.item.text = item

        holder.itemView.setOnClickListener {
            onItemClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
