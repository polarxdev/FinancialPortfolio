package com.example.financialportfolio.presentation.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.domain.interactor.PortfolioAssetListInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val portfolioAssetListInteractor: PortfolioAssetListInteractor
) : ViewModel() {
    private val _portfolioAssetList = MutableLiveData<List<PortfolioAsset>>()
    val portfolioAssetList: LiveData<List<PortfolioAsset>> get() = _portfolioAssetList

    init {
        loadPortfolioAssets()
    }

    private fun loadPortfolioAssets() {
        _portfolioAssetList.value = portfolioAssetListInteractor.getPortfolioAssetList()
    }

    fun addPortfolioAsset(asset: PortfolioAsset) {
        portfolioAssetListInteractor.addPortfolioAsset(asset)
        loadPortfolioAssets()
    }

    fun deletePortfolioAsset(asset: PortfolioAsset) {
        portfolioAssetListInteractor.deletePortfolioAsset(asset)
        loadPortfolioAssets()
    }
}
