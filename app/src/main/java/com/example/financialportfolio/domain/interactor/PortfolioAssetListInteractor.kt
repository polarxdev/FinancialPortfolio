package com.example.financialportfolio.domain.interactor

import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.domain.repository.PortfolioAssetsListRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PortfolioAssetListInteractor @Inject constructor(
    private val portfolioAssetsListRepository: PortfolioAssetsListRepository
) {
    suspend fun addPortfolioAsset(asset: PortfolioAsset) {
        portfolioAssetsListRepository.addPortfolioAsset(asset)
    }

    suspend fun deletePortfolioAsset(id: Int) {
        portfolioAssetsListRepository.deletePortfolioAsset(id)
    }

    suspend fun getPortfolioAssetList(): List<PortfolioAsset> {
        return portfolioAssetsListRepository.getPortfolioAssets()
    }
}
