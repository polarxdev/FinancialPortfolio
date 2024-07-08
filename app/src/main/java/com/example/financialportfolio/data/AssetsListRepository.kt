package com.example.financialportfolio.data

import com.example.financialportfolio.domain.entity.Asset

class AssetsListRepository {
    private var assets = listOf<Asset>()

    init {
        assets = DefaultAssetsList.getAssetsList()
    }

    fun getAssets(): List<Asset> {
        return assets
    }
}