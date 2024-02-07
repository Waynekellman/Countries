package com.example.countries

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.databinding.ActivityMainBinding

class MainActivity : Activity(), IMainActivity {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewmodel = CountriesViewModel(this)
        viewmodel.getCountries()

    }

    override fun connecting() {
        binding.connectionProgress.visibility = View.VISIBLE
    }

    override fun setCountries(countries: List<Country>) {
        runOnUiThread {
            binding.countriesView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.countriesView.adapter = CountriesAdapter(countries)
            binding.connectionProgress.visibility = View.GONE
        }
    }

    override fun connectionError() {
        runOnUiThread {
            binding.connectionError.visibility = View.VISIBLE
            binding.connectionProgress.visibility = View.GONE
        }
    }
}