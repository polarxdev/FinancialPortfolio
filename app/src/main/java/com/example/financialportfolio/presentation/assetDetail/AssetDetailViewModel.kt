package com.example.financialportfolio.presentation.assetDetail

import androidx.lifecycle.ViewModel
import com.example.financialportfolio.domain.entity.Asset
import com.example.financialportfolio.domain.usecase.GetAssetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AssetDetailViewModel
@Inject constructor(
    private val getAssetUseCase: GetAssetUseCase
) : ViewModel() {
    fun getAssetById(id: Int): Asset{
        return getAssetUseCase(id)
    }
}
