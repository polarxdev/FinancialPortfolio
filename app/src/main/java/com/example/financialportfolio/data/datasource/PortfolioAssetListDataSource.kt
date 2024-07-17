package com.example.financialportfolio.data.datasource

import com.example.financialportfolio.data.datasource.defaults.DefaultPortfolioAssetsList
import com.example.financialportfolio.domain.entity.PortfolioAsset

interface PortfolioAssetListDataSource {
    fun getPortfolioAssets(): List<PortfolioAsset>
    fun getPortfolioAssetById(id: Int): PortfolioAsset
}