package com.example.financialportfolio.di

import com.example.financialportfolio.data.AssetListRepositoryImpl
import com.example.financialportfolio.data.datasource.AssetListDataSource
import com.example.financialportfolio.data.datasource.local.LocalAssetListDataSource
import com.example.financialportfolio.domain.repository.AssetListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindAssetListRepository(
        repositoryImpl: AssetListRepositoryImpl
    ): AssetListRepository

    @Binds
    @Singleton
    fun bindAssetListDataSource(
        dataSourceImpl: LocalAssetListDataSource
    ): AssetListDataSource
}
