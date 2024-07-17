package com.example.financialportfolio.presentation.rv.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.R
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.entity.Stock
import com.example.financialportfolio.presentation.rv.AssetStockViewHolder

class AssetStockListItemAdapterDelegate(
    private val onClick: (Asset) -> Unit
) : AdapterDelegate<Asset> {
    override fun isForViewType(items: List<Asset>, position: Int): Boolean {
        return items.isNotEmpty() && items[position] is Stock
    }

    override fun onCreateViewHolder(parent: ViewGroup): AssetStockViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AssetStockViewHolder(
            layoutInflater.inflate(
                R.layout.item_asset_stock,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        items: List<Asset>,
        position: Int
    ) {
        (holder as AssetStockViewHolder).bind(items[position] as Stock, onClick)
    }
}
