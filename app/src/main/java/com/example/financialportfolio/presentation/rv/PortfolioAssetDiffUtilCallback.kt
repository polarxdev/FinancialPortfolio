package com.example.financialportfolio.presentation.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.financialportfolio.domain.entity.PortfolioAsset

class PortfolioAssetDiffUtilCallback (
    private val oldList: List<PortfolioAsset>,
    private val newList: List<PortfolioAsset>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}