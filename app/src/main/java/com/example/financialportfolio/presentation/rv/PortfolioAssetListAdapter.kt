package com.example.financialportfolio.presentation.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.presentation.rv.delegate.AdapterDelegatesManager
import com.example.financialportfolio.presentation.rv.delegate.DelegationAdapter

class PortfolioAssetListAdapter(
    delegatesManager: AdapterDelegatesManager<PortfolioAsset>,
    var items: List<PortfolioAsset>
) :
    DelegationAdapter<PortfolioAsset>(delegatesManager, items) {
    override fun createDiffUtilCallback(
        oldItems: List<PortfolioAsset>,
        newItems: List<PortfolioAsset>
    ): DiffUtil.Callback {
        return PortfolioAssetDiffUtilCallback(oldItems, newItems)
    }
}