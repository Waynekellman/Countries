package com.example.countries

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountriesViewModel(val view: IMainActivity): ViewModel() {
    val TAG: String = CountriesViewModel::class.java.simpleName
    private fun buildRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    fun getCountries() {
        val service = buildRetrofit().create(CountriesService::class.java)
        view.connecting()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val countries = service.getCountries()
                view.setCountries(countries);
            } catch (e: Exception) {
                Log.e(TAG, "getCountries: call error", e)
                view.connectionError()
            }
        }
    }
}