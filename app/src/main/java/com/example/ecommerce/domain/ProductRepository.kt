package com.example.ecommerce.domain

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.ecommerce.data.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProduct() : List<Product>
    fun letProductFlowDb(): Flow<PagingData<Product>>

}