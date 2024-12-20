package com.example.narutoborutoapp.data.remote

import com.example.narutoborutoapp.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoApi {

    @GET("/boruto/heroes")
    suspend fun getHeroes(
        @Query("page") page:Int = 1
    ):ApiResponse

    @GET("/boruto/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name:String
    ):ApiResponse



}