package com.example.financialportfolio.di

import com.example.financialportfolio.domain.repository.AssetListRepository
import com.example.financialportfolio.domain.usecase.GetAssetListUseCase
import com.example.financialportfolio.domain.usecase.GetAssetUseCase
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
    fun provideGetAssetUseCase(assetListRepository: AssetListRepository): GetAssetUseCase {
        return GetAssetUseCase(assetListRepository)
    }
}
