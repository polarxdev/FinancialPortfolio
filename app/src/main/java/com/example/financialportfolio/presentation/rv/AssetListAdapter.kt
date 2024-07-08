package com.example.financialportfolio.presentation.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.financialportfolio.R
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.entity.Bond
import com.example.financialportfolio.domain.entity.Cash
import com.example.financialportfolio.domain.entity.Stock
import com.example.financialportfolio.presentation.rv.AssetType.Companion.toLayoutType


enum class AssetType(val layoutResId: Int) {
    CASH(R.layout.item_asset_cash),
    BOND(R.layout.item_asset_bond),
    STOCK(R.layout.item_asset_stock);

    companion object {
        fun Asset.toLayoutType(): AssetType {
            return when (this) {
                is Cash -> CASH
                is Bond -> BOND
                is Stock -> STOCK
                else -> throw IllegalArgumentException("Invalid AssetType")
            }
        }
    }
}


class AssetListAdapter(
    private val onClick: (Asset) -> Unit
) : RecyclerView.Adapter<AssetViewHolder<*>>() {

    private var items = emptyList<Asset>()

    fun submitItems(newItems: List<Asset>) {
        val diffResult = DiffUtil.calculateDiff(
            AssetDiffUtilCallback(items, newItems)
        )
        items = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemViewType(position: Int): Int =
        items[position].toLayoutType().layoutResId


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder<*> {
        return ViewHolderFactoryProvider.newInstance(parent, viewType)
    }

    override fun onBindViewHolder(holder: AssetViewHolder<*>, position: Int) {
        val asset = items[position]
        when (holder) {
            is AssetCashViewHolder -> holder.bind(asset as Cash, onClick)
            is AssetStockViewHolder -> holder.bind(asset as Stock, onClick)
            is AssetBondViewHolder -> holder.bind(asset as Bond, onClick)
            else -> throw IllegalArgumentException("Unknown ViewHolder type")
        }
    }

    override fun getItemCount() = items.size

}