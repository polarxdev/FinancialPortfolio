package com.example.financialportfolio.domain.usecase

import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.repository.AssetListRepository

class GetAssetListUseCase(private val assetListRepository: AssetListRepository) {
    fun execute(): List<Asset> {
        return assetListRepository.getAssets()
    }
}
