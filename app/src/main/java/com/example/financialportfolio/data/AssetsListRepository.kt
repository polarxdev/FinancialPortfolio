package com.example.financialportfolio.data

import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.entity.Cash

class AssetsListRepository {
    private var assets = listOf<Asset>()

    init {
        assets = defaultAssetsList.getDefaultAssetsList()
    }

    fun getAssets(): List<Asset> {
        return assets
    }
}