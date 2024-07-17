package com.example.financialportfolio.di

import com.example.financialportfolio.domain.repository.AssetListRepository
import com.example.financialportfolio.domain.repository.PortfolioAssetsListRepository
import com.example.financialportfolio.domain.usecase.GetAssetListUseCase
import com.example.financialportfolio.domain.usecase.GetPortfolioAssetByIdUseCase
import com.example.financialportfolio.domain.usecase.GetPortfolioAssetListUseCase
import dagger.Binds
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
    fun provideGetPortfolioAssetListUseCase(portfolioAssetListRepository: PortfolioAssetsListRepository): GetPortfolioAssetListUseCase{
        return GetPortfolioAssetListUseCase((portfolioAssetListRepository))
    }

    @Provides
    fun provideGetPortfolioAssetByIdUseCase(portfolioAssetListRepository: PortfolioAssetsListRepository): GetPortfolioAssetByIdUseCase {
        return GetPortfolioAssetByIdUseCase((portfolioAssetListRepository))
    }
}
