package com.example.financialportfolio.domain.usecase

import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.domain.repository.PortfolioAssetsListRepository

class GetPortfolioAssetByIdUseCase(
    private val portfolioAssetsListRepository: PortfolioAssetsListRepository
) {
    operator fun invoke(id: Int): PortfolioAsset {
        return portfolioAssetsListRepository.getPortfolioAssetById(id)
    }
}