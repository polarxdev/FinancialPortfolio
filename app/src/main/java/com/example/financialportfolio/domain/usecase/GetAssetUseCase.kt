package com.example.financialportfolio.domain.usecase

import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.repository.AssetListRepository

class GetAssetUseCase(private val assetListRepository: AssetListRepository) {
    operator fun invoke(id: Int): Asset {
        return assetListRepository.getAssetById(id)
    }
}
