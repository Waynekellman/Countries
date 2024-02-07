package com.example.countries

interface IMainActivity {
    fun connecting()
    fun setCountries(countries: List<Country>)
    fun connectionError()
}