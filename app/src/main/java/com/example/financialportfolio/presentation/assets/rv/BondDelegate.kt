package com.example.financialportfolio.presentation.assets.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.R
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.entity.Bond
import com.example.financialportfolio.presentation.common.rv.AdapterDelegate

class BondDelegate(
    private val onClick: (Asset) -> Unit
) : AdapterDelegate<Asset> {
    override fun isForViewType(items: List<Asset>, position: Int): Boolean {
        return items.isNotEmpty() && items[position] is Bond
    }

    override fun onCreateViewHolder(parent: ViewGroup): AssetBondViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AssetBondViewHolder(layoutInflater.inflate(R.layout.item_asset_bond, parent, false))
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        items: List<Asset>,
        position: Int
    ) {
        (holder as AssetBondViewHolder).bind(items[position] as Bond, onClick)
    }
}
