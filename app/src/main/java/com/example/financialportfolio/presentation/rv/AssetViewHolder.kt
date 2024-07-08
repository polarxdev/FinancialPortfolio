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

}

interface ViewHolderFactory {
    fun create(parent: ViewGroup): AssetViewHolder<*>
}

class CashViewHolderFactory : ViewHolderFactory {
    override fun create(parent: ViewGroup): AssetViewHolder<*> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAssetCashBinding.inflate(layoutInflater, parent, false)
        return AssetCashViewHolder(binding)
    }
}

class StockViewHolderFactory : ViewHolderFactory {
    override fun create(parent: ViewGroup): AssetViewHolder<*> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAssetStockBinding.inflate(layoutInflater, parent, false)
        return AssetStockViewHolder(binding)
    }
}

class BondViewHolderFactory : ViewHolderFactory {
    override fun create(parent: ViewGroup): AssetViewHolder<*> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAssetBondBinding.inflate(layoutInflater, parent, false)
        return AssetBondViewHolder(binding)
    }
}

object ViewHolderFactoryProvider {
    private val factories = mapOf(
        R.layout.item_asset_cash to CashViewHolderFactory(),
        R.layout.item_asset_stock to StockViewHolderFactory(),
        R.layout.item_asset_bond to BondViewHolderFactory(),
    )

    fun newInstance(parent: ViewGroup, viewType: Int): AssetViewHolder<*> {
        val factory = factories[viewType] ?: throw IllegalArgumentException("Invalid view type")
        return factory.create(parent)
    }
}


class AssetCashViewHolder(private val binding: ItemAssetCashBinding) :
    AssetViewHolder<Cash>(binding.root) {

    override fun bind(model: Cash, onClick: (Cash) -> Unit) {
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

class AssetBondViewHolder(private val binding: ItemAssetBondBinding) :
    AssetViewHolder<Bond>(binding.root) {

    override fun bind(model: Bond, onClick: (Bond) -> Unit) {
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

class AssetStockViewHolder(private val binding: ItemAssetStockBinding) :
    AssetViewHolder<Stock>(binding.root) {

    override fun bind(model: Stock, onClick: (Stock) -> Unit) {
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

