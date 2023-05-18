package com.chutyrooms.mymvvmpractice

import androidx.lifecycle.LiveData

//Repository Database er shate communicate korbe , jar jnn dao er ekta object lagbe
class QuoteRepository(private val quoteDao: QouteDao) {

    fun getQuotes(): LiveData<List<Quote>>
    {
        return quoteDao.getQoutes()
    }

    suspend fun insertQuote(quote: Quote)
    {
        quoteDao.insertQuote(quote)
    }

}