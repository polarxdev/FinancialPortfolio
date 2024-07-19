package com.example.financialportfolio.data.datasource

import com.example.financialportfolio.domain.entity.PortfolioAsset

interface PortfolioAssetListDataSource {
    fun getPortfolioAssets(): List<PortfolioAsset>
    fun addPortfolioAsset(asset: PortfolioAsset)
    fun deletePortfolioAsset(asset: PortfolioAsset)
}
