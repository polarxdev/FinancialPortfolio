package com.example.financialportfolio.data.datasource.local

import com.example.financialportfolio.data.datasource.PortfolioAssetListDataSource
import com.example.financialportfolio.data.datasource.defaults.DefaultPortfolioAssetsList
import com.example.financialportfolio.domain.entity.PortfolioAsset
import javax.inject.Inject

class LocalPortfolioListDataSource @Inject constructor(): PortfolioAssetListDataSource {
    override fun getPortfolioAssets(): List<PortfolioAsset> {
        return DefaultPortfolioAssetsList.getPortfolioAssetsList()
    }

    override fun getPortfolioAssetById(id: Int): PortfolioAsset {
        return DefaultPortfolioAssetsList.getPortfolioAssetById(id)
    }
}