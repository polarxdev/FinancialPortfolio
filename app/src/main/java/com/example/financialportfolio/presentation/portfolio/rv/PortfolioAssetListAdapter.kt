package com.example.financialportfolio.presentation.portfolio.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.financialportfolio.presentation.common.rv.AdapterDelegatesManager
import com.example.financialportfolio.presentation.common.rv.DelegationAdapter
import com.example.financialportfolio.presentation.model.PortfolioAssetView

class PortfolioAssetListAdapter(
    delegatesManager: AdapterDelegatesManager<PortfolioAssetView>,
    var items: List<PortfolioAssetView>
) :
    DelegationAdapter<PortfolioAssetView>(delegatesManager, items) {
    override fun createDiffUtilCallback(
        oldItems: List<PortfolioAssetView>,
        newItems: List<PortfolioAssetView>
    ): DiffUtil.Callback {
        return PortfolioAssetDiffUtilCallback(oldItems, newItems)
    }
}
