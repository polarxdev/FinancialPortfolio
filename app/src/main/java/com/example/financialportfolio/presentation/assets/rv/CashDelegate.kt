package com.example.financialportfolio.presentation.assets.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.financialportfolio.R
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.entity.Cash
import com.example.financialportfolio.presentation.common.rv.AdapterDelegate

class CashDelegate(
    private val onClick: (Asset) -> Unit
) : AdapterDelegate<Asset> {
    override fun isForViewType(items: List<Asset>, position: Int): Boolean {
        return items.isNotEmpty() && items[position] is Cash
    }

    override fun onCreateViewHolder(parent: ViewGroup): AssetCashViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AssetCashViewHolder(layoutInflater.inflate(R.layout.item_asset_cash, parent, false))
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        items: List<Asset>,
        position: Int
    ) {
        (holder as AssetCashViewHolder).bind(items[position] as Cash, onClick)
    }
}
