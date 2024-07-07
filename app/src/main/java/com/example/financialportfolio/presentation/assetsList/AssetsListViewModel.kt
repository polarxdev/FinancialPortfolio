package com.example.financialportfolio.presentation.assetsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.financialportfolio.data.AssetsListRepository
import com.example.financialportfolio.domain.entity.Asset

class AssetsListViewModel : ViewModel() {
    private val repository = AssetsListRepository()

    private val _model = MutableLiveData<List<Asset>>()
    val model: LiveData<List<Asset>> get() = _model

    init {
        loadAssets()
    }

    private fun loadAssets() {
        _model.value = repository.getAssets()
    }
}