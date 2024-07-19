package com.example.financialportfolio.presentation.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.domain.usecase.AddPortfolioAssetUseCase
import com.example.financialportfolio.domain.usecase.DeletePortfolioAssetUseCase
import com.example.financialportfolio.domain.usecase.GetPortfolioAssetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val getPortfolioAssetListUseCase: GetPortfolioAssetListUseCase,
    private val addPortfolioAssetUseCase: AddPortfolioAssetUseCase,
    private val deletePortfolioAssetUseCase: DeletePortfolioAssetUseCase
) : ViewModel() {
    private val _model = MutableLiveData<List<PortfolioAsset>>()
    val model: LiveData<List<PortfolioAsset>> get() = _model

    init {
        loadPortfolioAssets()
    }

    private fun loadPortfolioAssets() {
        _model.value = getPortfolioAssetListUseCase()
    }

    fun addPortfolioAsset(asset: PortfolioAsset) {
        addPortfolioAssetUseCase(asset)
        _model.value = getPortfolioAssetListUseCase()
    }

    fun deletePortfolioAsset(asset: PortfolioAsset) {
        deletePortfolioAssetUseCase(asset)
        _model.value = getPortfolioAssetListUseCase()
    }
}
