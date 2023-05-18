package com.chutyrooms.mymvvmpractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository: QuoteRepository):ViewModel() {

    fun getQuotes():LiveData<List<Quote>>
    {
        return quoteRepository.getQuotes()
    }

     fun insertQuotes(quote: Quote)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            quoteRepository.insertQuote(quote)
        }

    }
}