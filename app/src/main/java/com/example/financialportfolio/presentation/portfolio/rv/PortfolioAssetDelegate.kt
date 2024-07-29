package com.example.financialportfolio.presentation.portfolio.rv

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.R
import com.example.financialportfolio.presentation.common.rv.AdapterDelegate
import com.example.financialportfolio.presentation.model.PortfolioAssetView

class PortfolioAssetDelegate(
    private val onMenuItemClick: (PortfolioAssetView, MenuItem) -> Unit
) : AdapterDelegate<PortfolioAssetView> {
    override fun isForViewType(items: List<PortfolioAssetView>, position: Int): Boolean {
        return items[position] is PortfolioAssetView
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
        items: List<PortfolioAssetView>,
        position: Int
    ) {
        (holder as PortfolioAssetViewHolder).bind(items[position], onMenuItemClick)
    }
}
