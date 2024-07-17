package com.example.financialportfolio.domain.usecase

import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.domain.repository.PortfolioAssetsListRepository

class GetPortfolioAssetListUseCase(
    private val portfolioAssetsListRepository: PortfolioAssetsListRepository
) {
    operator fun invoke(): List<PortfolioAsset> {
        return portfolioAssetsListRepository.getPortfolioAssets()
    }
}