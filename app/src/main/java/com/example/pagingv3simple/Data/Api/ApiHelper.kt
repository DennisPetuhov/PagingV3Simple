package com.example.pagingv3simple.Data.Api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiHelper {


    // Base url of the api
    private const val BASE_URL = "https://reqres.in/"

    // create retrofit service
    fun apiService(): ApiService =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiService::class.java)
}
