package com.example.financialportfolio.domain.usecase

import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.domain.repository.PortfolioAssetsListRepository

class DeletePortfolioAssetUseCase(
    private val portfolioAssetsListRepository: PortfolioAssetsListRepository
) {
    operator fun invoke(asset: PortfolioAsset) {
        portfolioAssetsListRepository.deletePortfolioAsset(asset)
    }
}