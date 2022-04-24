package com.example.ecommerce.domain

import com.example.ecommerce.data.Product

interface ProductRepository {

    suspend fun getProduct() : List<Product>
}