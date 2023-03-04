package com.example.pagingv3simple.Data.Api

import com.example.pagingv3simple.Data.Model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/users")
    suspend fun getListData(@Query("page") pageNumber: Int): Response<ApiResponse>
}