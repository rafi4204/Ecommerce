package com.example.ecommerce.common.network

import com.example.ecommerce.data.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}