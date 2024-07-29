package com.example.financialportfolio.data.datasource

import com.example.financialportfolio.domain.entity.Asset

interface AssetListDataSource {
    fun getAssets(): List<Asset>
    fun getAssetById(id: Int): Asset
}
