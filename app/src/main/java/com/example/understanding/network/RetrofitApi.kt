package com.example.understanding.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {
    @GET("/")
    suspend fun getData(
        @Query("s") tag: String,
        @Query("apikey") apiKey: String = "f7dc1c21"
    ): Response<ItemResponse>
}