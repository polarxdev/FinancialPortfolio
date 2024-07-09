package com.example.financialportfolio.di

import com.example.financialportfolio.domain.repository.AssetListRepository
import com.example.financialportfolio.domain.usecase.GetAssetListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetAssetListUseCase(assetListRepository: AssetListRepository): GetAssetListUseCase {
        return GetAssetListUseCase(assetListRepository)
    }
}
