import android.app.Application
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val context: Context get() = getApplication<Application>().applicationContext

    private val Context.dataStore by preferencesDataStore(name = "settings")

    private val _selectedCurrency = MutableLiveData<String>()
    val selectedCurrency: LiveData<String> get() = _selectedCurrency

    suspend fun selectCurrency(currency: String) {
        _selectedCurrency.value = currency
        saveCurrencyToPreferences(currency)
    }

    fun readCurrencyFromPreferences(): Flow<String> {
        return context.dataStore.data
            .map { preferences ->
                preferences[PreferencesKeys.CURRENCY] ?: "BYN"
            }
    }

    suspend fun saveCurrencyToPreferences(currency: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.CURRENCY] = currency
        }
    }

    object PreferencesKeys {
        val CURRENCY = stringPreferencesKey("currency")
    }
}
