package com.example.financialportfolio.presentation.settings

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financialportfolio.domain.interactor.SettingsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsInteractor: SettingsInteractor
) : ViewModel() {
    private val _selectedCurrency = MutableLiveData<String>()
    val selectedCurrency: LiveData<String> get() = _selectedCurrency

    fun selectCurrency(currency: String) {
        _selectedCurrency.value = currency
    }

    fun getSettingsList(): ArrayList<String> = settingsInteractor.getSettingsList()

    fun readCurrencyFromPreferences(context: Context) {
        viewModelScope.launch {
            settingsInteractor.readCurrencyFromPreferences(context).collect { value ->
                _selectedCurrency.postValue(value)
            }
        }
    }

    fun saveCurrencyToPreferences(currency: String, context: Context) {
        viewModelScope.launch {
            return@launch settingsInteractor.saveCurrencyToPreferences(currency, context)
        }
    }
}
