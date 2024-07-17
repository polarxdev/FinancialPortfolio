package com.example.financialportfolio.presentation.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financialportfolio.domain.entity.PortfolioAsset
import com.example.financialportfolio.domain.usecase.GetPortfolioAssetByIdUseCase
//import com.example.financialportfolio.domain.usecase.AddAssetToPortfolioUseCase
import com.example.financialportfolio.domain.usecase.GetPortfolioAssetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PortfolioViewModel
@Inject constructor(
    private val getPortfolioAssetListUseCase: GetPortfolioAssetListUseCase,
    private val getPortfolioAssetByIdUseCase: GetPortfolioAssetByIdUseCase
) :
    ViewModel() {
    private val _model = MutableLiveData<List<PortfolioAsset>>()
    val model: LiveData<List<PortfolioAsset>> get() = _model

    init {
        loadPortfolioAssets()
    }

    private fun loadPortfolioAssets() {
        _model.value = getPortfolioAssetListUseCase()
    }

    fun getPortfolioAssetById(id: Int): LiveData<PortfolioAsset> {
        val asset = MutableLiveData<PortfolioAsset>()
        asset.value = getPortfolioAssetByIdUseCase(id)
        return asset
    }
}