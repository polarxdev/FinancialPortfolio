package com.example.financialportfolio.presentation.portfolio.rv

import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.ItemPortfolioAssetBinding
import com.example.financialportfolio.presentation.model.PortfolioAssetView

class PortfolioAssetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemPortfolioAssetBinding = ItemPortfolioAssetBinding.bind(itemView)
    fun bind(model: PortfolioAssetView, onMenuItemClick: (PortfolioAssetView, MenuItem) -> Unit) {
        with(binding) {
            name.text = model.name
            currentPrice.text = model.currentPrice
            purchaseDate.text = model.purchaseDate
            purchasePrice.text = model.purchasePrice
            menu.setOnClickListener { view ->
                showPopupMenu(view, model, onMenuItemClick)
            }
        }
    }

    private fun showPopupMenu(
        view: View,
        asset: PortfolioAssetView,
        onMenuItemClick: (PortfolioAssetView, MenuItem) -> Unit
    ) {
        val popupMenu = PopupMenu(view.context, view)
        popupMenu.inflate(R.menu.portfolio_item_menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            onMenuItemClick(asset, menuItem)
            true
        }
        popupMenu.show()
    }
}
