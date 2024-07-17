package com.example.financialportfolio.presentation.rv

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.financialportfolio.databinding.ItemAssetBondBinding
import com.example.financialportfolio.databinding.ItemAssetCashBinding
import com.example.financialportfolio.databinding.ItemAssetStockBinding
import com.example.financialportfolio.databinding.ItemPortfolioAssetBinding
import com.example.financialportfolio.domain.entity.Bond
import com.example.financialportfolio.domain.entity.Cash
import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.domain.entity.Stock

class AssetCashViewHolder(itemView: View) : ViewHolder(itemView) {
    private val binding: ItemAssetCashBinding = ItemAssetCashBinding.bind(itemView)
    fun bind(model: Cash, onClick: (Cash) -> Unit) {
        with(binding) {
            model.let {
                name.text = model.name
                currency.text = model.currency
                country.text = model.meta.country
                sector.text = model.meta.sector

                itemView.setOnClickListener { onClick(model) }
            }
        }
    }
}

class AssetBondViewHolder(itemView: View) : ViewHolder(itemView) {
    private val binding: ItemAssetBondBinding = ItemAssetBondBinding.bind(itemView)
    fun bind(model: Bond, onClick: (Bond) -> Unit) {
        with(binding) {
            model.let {
                name.text = model.name
                maturityDate.text = model.maturityDate.toString()
                country.text = model.meta.country
                sector.text = model.meta.sector

                itemView.setOnClickListener { onClick(model) }
            }
        }
    }
}

class AssetStockViewHolder(itemView: View) : ViewHolder(itemView) {
    private val binding: ItemAssetStockBinding = ItemAssetStockBinding.bind(itemView)
    fun bind(model: Stock, onClick: (Stock) -> Unit) {
        with(binding) {
            model.let {
                name.text = model.name
                ticker.text = model.ticker
                country.text = model.meta.country
                sector.text = model.meta.sector

                itemView.setOnClickListener { onClick(model) }
            }
        }
    }
}

class PortfolioAssetViewHolder(itemView: View) : ViewHolder(itemView) {
    private val binding: ItemPortfolioAssetBinding = ItemPortfolioAssetBinding.bind(itemView)
    fun bind(model: PortfolioAsset, onClick: (PortfolioAsset) -> Unit) {
        with(binding) {
            model.let {
                name.text = model.id.toString()

                itemView.setOnClickListener { onClick(model) }
            }
        }
    }
}