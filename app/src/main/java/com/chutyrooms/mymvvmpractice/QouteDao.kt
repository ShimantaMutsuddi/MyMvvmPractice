package com.chutyrooms.mymvvmpractice

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface QouteDao {

    @Query("SELECT * FROM quote")
    fun getQoutes(): LiveData<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)
}