package com.example.ecommerce.common.network

import com.example.ecommerce.data.Product
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>

    @GET("products")
    suspend fun getProducts(@Query("limit") limit: Int): List<Product>
}