package com.example.financialportfolio.data

import com.example.financialportfolio.domain.entity.Asset

class AssetsListRepository {
    private var assets = listOf<Asset>()

    init {
        assets = DefaultAssetsList.getDefaultAssetsList()
    }

    fun getAssets(): List<Asset> {
        return assets
    }
}