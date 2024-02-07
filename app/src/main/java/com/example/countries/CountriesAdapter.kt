package com.example.countries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.databinding.ItemCountryBinding

class CountriesAdapter(val countriesList: List<Country>):
    RecyclerView.Adapter<CountrieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountrieViewHolder {
        return CountrieViewHolder(ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = countriesList.size

    override fun onBindViewHolder(holder: CountrieViewHolder, position: Int) {
        holder.onBind(countriesList[position])
    }
}
class CountrieViewHolder(val binding: ItemCountryBinding): RecyclerView.ViewHolder(binding.root) {
    fun onBind(country: Country) {
        val nameRegionText = "${country.name}, ${country.region}"
        binding.nameRegion.text = nameRegionText
        binding.code.text = country.code
        binding.capital.text = country.capital
    }
}