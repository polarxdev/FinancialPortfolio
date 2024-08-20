package com.example.financialportfolio.data.datasource

import com.example.financialportfolio.domain.entity.PortfolioAsset

interface PortfolioAssetListDataSource {
    suspend fun getPortfolioAssets(): List<PortfolioAsset>
    suspend fun addPortfolioAsset(asset: PortfolioAsset)
    suspend fun deletePortfolioAsset(id: Int)
}
