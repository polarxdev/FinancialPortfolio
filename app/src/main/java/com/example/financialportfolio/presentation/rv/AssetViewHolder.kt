package com.example.financialportfolio.presentation.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.R
import com.example.financialportfolio.databinding.ItemAssetBondBinding
import com.example.financialportfolio.databinding.ItemAssetCashBinding
import com.example.financialportfolio.databinding.ItemAssetStockBinding
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.entity.Bond
import com.example.financialportfolio.domain.entity.Cash
import com.example.financialportfolio.domain.entity.Stock

abstract class AssetViewHolder<T : Asset>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(model: T, onClick: (T) -> Unit)

    companion object {
        fun newInstance(parent: ViewGroup, viewType: Int): AssetViewHolder<*> {
            val layoutInflater = LayoutInflater.from(parent.context)
            return when (viewType) {
                R.layout.item_asset_cash -> {
                    val binding = ItemAssetCashBinding.inflate(layoutInflater, parent, false)
                    AssetCashViewHolder(binding)
                }

                R.layout.item_asset_stock -> {
                    val binding = ItemAssetStockBinding.inflate(layoutInflater, parent, false)
                    AssetStockViewHolder(binding)
                }

                R.layout.item_asset_bond -> {
                    val binding = ItemAssetBondBinding.inflate(layoutInflater, parent, false)
                    AssetBondViewHolder(binding)
                }

                else -> throw IllegalArgumentException("Invalid view type")
            }
        }
    }
}


class AssetCashViewHolder(private val binding: ItemAssetCashBinding) :
    AssetViewHolder<Cash>(binding.root) {

    override fun bind(model: Cash, onClick: (Cash) -> Unit) {
        with(binding) {
            model.let {
                name.text = model.name
                amount.text = model.amount.toString()
                currency.text = model.currency
                country.text = model.meta.country
                sector.text = model.meta.sector

                itemView.setOnClickListener { onClick(model) }
            }
        }
    }
}

class AssetBondViewHolder(private val binding: ItemAssetBondBinding) :
    AssetViewHolder<Bond>(binding.root) {

    override fun bind(model: Bond, onClick: (Bond) -> Unit) {
        with(binding) {
            model.let {
                name.text = model.name
                amount.text = model.amount.toString()
                maturityDate.text = model.maturityDate.toString()
                country.text = model.meta.country
                sector.text = model.meta.sector

                itemView.setOnClickListener { onClick(model) }
            }
        }
    }
}

class AssetStockViewHolder(private val binding: ItemAssetStockBinding) :
    AssetViewHolder<Stock>(binding.root) {

    override fun bind(model: Stock, onClick: (Stock) -> Unit) {
        with(binding) {
            model.let {
                name.text = model.name
                amount.text = model.amount.toString()
                ticker.text = model.ticker
                country.text = model.meta.country
                sector.text = model.meta.sector

                itemView.setOnClickListener { onClick(model) }
            }
        }
    }
}

