package com.example.financialportfolio.data.datasource.local

import com.example.financialportfolio.data.datasource.PortfolioAssetListDataSource
import com.example.financialportfolio.data.datasource.defaults.DefaultPortfolioAssetsList
import com.example.financialportfolio.domain.entity.PortfolioAsset
import javax.inject.Inject

class LocalPortfolioListDataSource @Inject constructor() : PortfolioAssetListDataSource {
    override fun getPortfolioAssets(): List<PortfolioAsset> {
        return DefaultPortfolioAssetsList.getPortfolioAssetsList()
    }

    override fun addPortfolioAsset(asset: PortfolioAsset) {
        DefaultPortfolioAssetsList.addPortfolioAsset(asset)
    }

    override fun deletePortfolioAsset(asset: PortfolioAsset) {
        DefaultPortfolioAssetsList.deletePortfolioAsset(asset)
    }
}
