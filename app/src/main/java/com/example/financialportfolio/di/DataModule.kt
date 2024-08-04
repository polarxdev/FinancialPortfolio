package com.example.financialportfolio.di

import com.example.financialportfolio.data.AssetListRepositoryImpl
import com.example.financialportfolio.data.ExchangeRateRepositoryImpl
import com.example.financialportfolio.data.PortfolioAssetListRepositoryImpl
import com.example.financialportfolio.data.datasource.AssetListDataSource
import com.example.financialportfolio.data.datasource.PortfolioAssetListDataSource
import com.example.financialportfolio.data.datasource.local.LocalAssetListDataSource
import com.example.financialportfolio.data.datasource.local.LocalPortfolioListDataSource
import com.example.financialportfolio.data.exchangerate.ExchangeRateApiService
import com.example.financialportfolio.domain.repository.AssetListRepository
import com.example.financialportfolio.domain.repository.ExchangeRateRepository
import com.example.financialportfolio.domain.repository.PortfolioAssetsListRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
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

    @Binds
    @Singleton
    fun bindPortfolioAssetListRepository(
        repositoryImpl: PortfolioAssetListRepositoryImpl
    ): PortfolioAssetsListRepository

    @Binds
    @Singleton
    fun bindPortfolioAssetListDataSource(
        dataSourceImpl: LocalPortfolioListDataSource
    ): PortfolioAssetListDataSource

    @Binds
    @Singleton
    fun bindExchangeRateRepository(
        repositoryImpl: ExchangeRateRepositoryImpl
    ): ExchangeRateRepository

    @Provides
    @Singleton
    fun provideExchangeRateApiService(): ExchangeRateApiService {

        val BASE_URL = "https://api.nbrb.by/exrates/rates/"
        val contentType = "application/json".toMediaType()

        val okHttpClient by lazy {
            OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
        }

        val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(Json.asConverterFactory(contentType))
                .build()
        }

        return retrofit.create(ExchangeRateApiService::class.java)
    }
}
