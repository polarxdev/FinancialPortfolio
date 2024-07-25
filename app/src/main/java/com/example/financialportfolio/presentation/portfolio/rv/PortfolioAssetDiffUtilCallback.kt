package com.example.financialportfolio.presentation.portfolio.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.financialportfolio.presentation.model.PortfolioAssetView

class PortfolioAssetDiffUtilCallback(
    private val oldList: List<PortfolioAssetView>,
    private val newList: List<PortfolioAssetView>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}
