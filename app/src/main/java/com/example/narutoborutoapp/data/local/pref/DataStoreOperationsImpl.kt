package com.example.narutoborutoapp.data.local.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.narutoborutoapp.Constants.PREFERENCES_KEY
import com.example.narutoborutoapp.Constants.PREFERENCES_NAME
import com.example.narutoborutoapp.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class DataStoreOperationsImpl(context: Context): DataStoreOperations {

    private object PreferencesKey {
        val onBoardingKey= booleanPreferencesKey(name= PREFERENCES_KEY)
    }

    private val dataStore=context.dataStore

    override suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { preferences->
            preferences[PreferencesKey.onBoardingKey]=completed
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception->
                if(exception is IOException){
                    emit(emptyPreferences())
                }else{
                    throw exception
                }
            }.map { preferences ->
                val onBoardingState=preferences[PreferencesKey.onBoardingKey]?:false
                onBoardingState
            }
    }

}