package com.example.financialportfolio.data.datasource.local

import com.example.financialportfolio.data.DefaultAssetsList
import com.example.financialportfolio.data.datasource.AssetListDataSource
import com.example.financialportfolio.domain.entity.Asset
import javax.inject.Inject

class LocalAssetListDataSource @Inject constructor() : AssetListDataSource {
    override fun getAssets(): List<Asset> {
        return DefaultAssetsList.getAssetsList()
    }
}
