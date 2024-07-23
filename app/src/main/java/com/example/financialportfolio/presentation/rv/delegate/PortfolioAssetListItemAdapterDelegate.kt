package com.example.financialportfolio.presentation.rv.delegate

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.R
import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.presentation.rv.PortfolioAssetViewHolder

class PortfolioAssetListItemAdapterDelegate(
    private val onMenuItemClick: (PortfolioAsset, MenuItem) -> Unit
) : AdapterDelegate<PortfolioAsset> {
    override fun isForViewType(items: List<PortfolioAsset>, position: Int): Boolean {
        return items[position] is PortfolioAsset
    }

    override fun onCreateViewHolder(parent: ViewGroup): PortfolioAssetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PortfolioAssetViewHolder(
            layoutInflater.inflate(
                R.layout.item_portfolio_asset,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        items: List<PortfolioAsset>,
        position: Int
    ) {
        (holder as PortfolioAssetViewHolder).bind(items[position], onMenuItemClick)
    }
}
