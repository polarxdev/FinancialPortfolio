package com.example.financialportfolio.presentation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _selectedCurrency = MutableLiveData<String>()
    val selectedCurrency: LiveData<String> get() = _selectedCurrency

    fun selectCurrency(currency: String) {
        _selectedCurrency.value = currency
    }
}
