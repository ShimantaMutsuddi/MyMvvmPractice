package com.chutyrooms.mymvvmpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.chutyrooms.mymvvmpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val qouteDao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository = QuoteRepository(qouteDao)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.getQuotes().observe(this) {
            binding.quotes = it.toString()
        }

        binding.btnAddQuote.setOnClickListener {
            val quote=Quote(0,"No excuse ..","Habu")
            mainViewModel.insertQuotes(quote)


        }
    }
}