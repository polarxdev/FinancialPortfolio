package com.example.financialportfolio.di

import com.example.financialportfolio.domain.repository.AssetListRepository
import com.example.financialportfolio.domain.repository.PortfolioAssetsListRepository
import com.example.financialportfolio.domain.usecase.AddPortfolioAssetUseCase
import com.example.financialportfolio.domain.usecase.DeletePortfolioAssetUseCase
import com.example.financialportfolio.domain.usecase.GetAssetListUseCase
import com.example.financialportfolio.domain.usecase.GetPortfolioAssetListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetAssetListUseCase(assetListRepository: AssetListRepository): GetAssetListUseCase {
        return GetAssetListUseCase(assetListRepository)
    }

    @Provides
    fun provideGetPortfolioAssetListUseCase(
        portfolioAssetListRepository: PortfolioAssetsListRepository
    ): GetPortfolioAssetListUseCase {
        return GetPortfolioAssetListUseCase(portfolioAssetListRepository)
    }

    @Provides
    fun provideAddPortfolioAssetUseCase(
        portfolioAssetListRepository: PortfolioAssetsListRepository
    ): AddPortfolioAssetUseCase {
        return AddPortfolioAssetUseCase(portfolioAssetListRepository)
    }

    @Provides
    fun provideDeletePortfolioAssetUseCase(
        portfolioAssetListRepository: PortfolioAssetsListRepository
    ): DeletePortfolioAssetUseCase {
        return DeletePortfolioAssetUseCase(portfolioAssetListRepository)
    }
}
