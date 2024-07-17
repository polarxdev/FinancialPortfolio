package com.example.financialportfolio.presentation.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.presentation.rv.delegate.AdapterDelegatesManager
import com.example.financialportfolio.presentation.rv.delegate.DelegationAdapter

class AssetListAdapter(
    delegatesManager: AdapterDelegatesManager<Asset>,
    var items: List<Asset>
) :
    DelegationAdapter<Asset>(delegatesManager, items) {
    override fun createDiffUtilCallback(
        oldItems: List<Asset>,
        newItems: List<Asset>
    ): DiffUtil.Callback {
        return AssetDiffUtilCallback(oldItems, newItems)
    }
}
