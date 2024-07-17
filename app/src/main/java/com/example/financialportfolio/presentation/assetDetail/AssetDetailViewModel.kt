package com.example.financialportfolio.presentation.assetDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.usecase.GetAssetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AssetDetailViewModel
@Inject constructor(
    private val getAssetDetailUseCase: GetAssetListUseCase
) : ViewModel() {

    private val _model = MutableLiveData<List<Asset>>()
    val model: LiveData<List<Asset>> get() = _model

    init {
        loadAsset()
    }

    private fun loadAsset() {
        _model.value = getAssetDetailUseCase()
    }
}
