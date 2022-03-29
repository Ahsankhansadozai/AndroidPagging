package com.example.androidpagging.retrofit

import com.example.androidpagging.model.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteAPI {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): QuoteList

}