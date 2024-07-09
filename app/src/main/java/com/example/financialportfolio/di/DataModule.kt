package com.example.financialportfolio.di

import com.example.financialportfolio.data.AssetListRepositoryImpl
import com.example.financialportfolio.data.datasource.AssetListDataSource
import com.example.financialportfolio.data.datasource.local.LocalAssetListDataSource
import com.example.financialportfolio.domain.repository.AssetListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideAssetListRepository(dataSource: AssetListDataSource): AssetListRepository {
        return AssetListRepositoryImpl(dataSource = dataSource)
    }

    @Provides
    @Singleton
    fun provideAssetListDataSource(): AssetListDataSource {
        return LocalAssetListDataSource()
    }
}
